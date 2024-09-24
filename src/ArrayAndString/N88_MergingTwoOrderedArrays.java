package ArrayAndString;

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//        注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。


public class N88_MergingTwoOrderedArrays {
    public static void main(String[] args) {
        int nums1[] = {2,0};
        int m = 1;
        int nums2[] = {1};
        int n = 1;
//        测试
//        invertedDoublePointer(nums1,m,nums2,n);
        invertedDoublePointer2(nums1,m,nums2,n);
//        merge(nums1,m,nums2,n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int auxiliaryArray[] = new int[m+n];//辅助数组
        //nums1、nums2、auxiliaryArray的左指针
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        while (l3<m+n){
            //nums1结束
            if (l1 == m){
                auxiliaryArray[l3] = nums2[l2];
                l2++;
                l3++;
                continue;
            }
            //nums2结束
            if (l2 == n){
                auxiliaryArray[l3] = nums1[l1];
                l1++;
                l3++;
                continue;
            }
            //还没结束，双指针选最小的放到辅助数组
            if (nums1[l1]<=nums2[l2]){
                auxiliaryArray[l3] = nums1[l1];
                l1++;
                l3++;
            }else {
                auxiliaryArray[l3] = nums2[l2];
                l2++;
                l3++;
            }
        }
        //将辅助数组中的内容放到nums1中
        for (int i = 0; i < auxiliaryArray.length; i++) {
            nums1[i] = auxiliaryArray[i];
        }

    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void invertedDoublePointer(int[] nums1, int m, int[] nums2, int n) {
        //三个右指针，从右侧逐渐减小；
        int l1 = m-1;
        int l2 = n-1;
        int l3 = m+n-1;
        while (l3>=0){
            //nums1结束
            if (l1 < 0){
                nums1[l3] = nums2[l2];
                l2--;
                l3--;
                continue;
            }
            //nums2结束
            if (l2 < 0){
                nums1[l3] = nums1[l1];
                l1--;
                l3--;
                continue;
            }
            //nums1更大
            if (nums1[l1]>nums2[l2]){
                nums1[l3] = nums1[l1];
                l1--;
                l3--;
                continue;
            }
            //nums2更大
            if (nums1[l1]<=nums2[l2]){
                nums1[l3] = nums2[l2];
                l2--;
                l3--;
            }
        }

    }

    /**
     * invertedDoublePointer的优化
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void invertedDoublePointer2(int[] nums1, int m, int[] nums2, int n) {
        //三个右指针，从右侧逐渐减小；
        int l1 = m-1;
        int l2 = n-1;
        int l3 = m+n-1;
        while(l1>=0&&l2>=0){//如果有一个数组遍历结束了就结束
            if (nums1[l1]>nums2[l2]){
                nums1[l3--] = nums1[l1--];
            }else {
                nums1[l3--] = nums2[l2--];
            }
        }
        while (l2>=0){//如果nums2中有剩余，就把nums2中的内容移到nums1中
            nums1[l3--] = nums2[l2--];
        }
    }
}

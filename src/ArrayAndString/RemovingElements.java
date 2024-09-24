package ArrayAndString;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemovingElements {
    public static void main(String[] args) {
//        nums = [3,2,2,3], val = 3
        int[] nums = {3,2,2,3};
        int val = 3;
//        nums = [0,1,2,2,3,0,4,2], val = 2
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;
        int ans = removeElement(nums,val);

        System.out.println("元素个数时是：");
        System.out.println(ans);
        System.out.println("每个元素分别是：");
        for (int i = 0;i<ans;i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 移除元素,思路错误
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == val){

                if (i+count>nums.length){
                    break;
                }
                while (nums[i+count]==val){
                    count++;
                }
                nums[i] = nums[i+count];


            }
        }
        return  nums.length-count;
    }


    /**
     * 移除元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == val){
                count=0;

                while (nums[i+count]==val){
                    count++;
                    if (i+count==nums.length){
                        break;
                    }
                }
                if (i+count==nums.length){
                    break;
                }
                nums[i] = nums[i+count];
                nums[i+count] = val;


            }
        }
        return  nums.length-count;
    }
}

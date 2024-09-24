package ArrayAndString;


/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemovingDuplicatesFromAnOrderedArrayII {
    public static void main(String[] args) {

    }


    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int temp = nums[0];
        temp = temp-1;
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[start] == nums[i]){
                count++;
                if (count>2){
                    nums[i] = temp;
                }
                continue;
            }else {
                start = start+count;
                count = 0;
                if (nums[start] == temp){
                    nums[start] = nums[i];
                }
            }
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == temp){

            }
        }
        return ans;
    }
}

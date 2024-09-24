package ArrayAndString;

public class N80_RemoveDuplicatesFromAnOrderedArray {
    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 2;
        return process(k,nums);
    }

    public static int process(int k, int[] nums){
        if (nums.length<=k){
            return nums.length;
        }else {
            int left = k;
            for (int right = k;right<nums.length;right++){
                if (nums[right] != nums[left-k]){
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }
    }
}

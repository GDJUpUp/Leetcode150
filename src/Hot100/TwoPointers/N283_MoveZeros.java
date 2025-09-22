package Hot100.TwoPointers;

public class N283_MoveZeros {

    public static void main(String[] args) {

    }


    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length&&left<nums.length) {
            if (nums[left] != 0) {
                left++;

            }else {
                right = left+1;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right < nums.length) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left++;
                }
            }
        }
    }
}

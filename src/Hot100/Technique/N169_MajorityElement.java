package Hot100.Technique;

import java.util.Arrays;

public class N169_MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementOptimized(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (res[1] == 0) {
                res[0] = nums[i];
                res[1] += 1;
            }else if (res[0] == nums[i]) {
                res[1] += 1;
            }else  {
                res[1] -= 1;
            }
        };
        return res[0];
    }
}

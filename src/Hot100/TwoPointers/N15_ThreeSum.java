package Hot100.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15_ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int first = 0;
        int second = first + 1;
        int third = second + 1;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (first = 0; first < nums.length - 2; first++) {
            int target = 0 - nums[first];
            if
        }
    }


}

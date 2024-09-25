package ArrayAndString;

import java.util.HashMap;

public class N169_MostElements {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,1,1,1,2,2};
        int[] nums2 = new int[]{3,2,3};
        int[] nums3 = new int[]{2};
        System.out.println(majorityElementMooreVotes(nums1));
        System.out.println(majorityElementMooreVotes(nums2));
        System.out.println(majorityElementMooreVotes(nums3));
    }

    public static int majorityElementMooreVotes(int[] nums) {
        int vote = 1;
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0){
                x = nums[i];
                vote++;
            }else {
                if (nums[i]!= x){
                    vote--;
                }else {
                    vote++;
                }
            }
        }
        return x;
    }
}

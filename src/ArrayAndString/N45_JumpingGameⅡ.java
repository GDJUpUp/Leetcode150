package ArrayAndString;

import java.util.Arrays;

public class N45_JumpingGameⅡ {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        int[] arr2 = new int[]{2,3,0,1,4};
        System.out.println(jumpGreed(arr));
        System.out.println(jumpGreed(arr2));
    }

    public static int jump(int[] nums) {
        int[] minSteps = new int[nums.length];
        Arrays.fill(minSteps , 10000000);
        minSteps[nums.length-1] = 0;
        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = 1; j <= nums[i]&&i+j<nums.length; j++) {
                minSteps[i] = Math.min(1 + minSteps[i + j], minSteps[i]);
            }
        }
        return minSteps[0];
    }

    public static int jumpGreed(int[] nums) {
        int step = 0;
        int maxBoundary = 0;
        int currentBoundary = 0;
        for (int i = 0; i < nums.length&&i<=currentBoundary; i++) {
            maxBoundary = Math.max(maxBoundary,i+nums[i]);
            if (i == currentBoundary&&i != nums.length-1){
                currentBoundary = maxBoundary;
                step++;
            }
        }
        return step;
    }
}

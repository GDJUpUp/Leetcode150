package ArrayAndString;

public class N55_JumpingGame {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        int[] arr2 = new int[]{3,2,1,0,4};
        System.out.println(canJump(arr));
        System.out.println(canJump(arr2));
    }

    public static boolean canJump(int[] nums) {
        int canJumpLeft = nums.length-1;
        for (int i = nums.length-1;i>=0;i--){
            if (i+nums[i]>=canJumpLeft) canJumpLeft = i;

        }
        return (canJumpLeft == 0);
    }
}

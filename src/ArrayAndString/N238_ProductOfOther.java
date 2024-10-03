package ArrayAndString;

public class N238_ProductOfOther {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        int[] ints2 = productExceptSelf(new int[]{-1,1,0,-3,3});
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print(" ");
        }
        for (int anInt : ints2) {
            System.out.print(anInt);
            System.out.print(" ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1]*ans[i-1];
        }
        int rightProduct = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }
}

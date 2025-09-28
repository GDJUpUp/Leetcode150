package Hot100.Technique;

public class N136_SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

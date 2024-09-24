package ArrayAndString;

public class RemoveDuplicatesFromAnOrderedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println(k);
        for (int i = 0;i<k;i++){
            System.out.println(nums[i]);
        }
    }

    public  static int removeDuplicates(int[] nums) {
        int k = 0;
        int right = 1;
        int temp = nums[0];
        while (right != nums.length){
            if (nums[right] == temp){
                right++;
            }else {
                k++;
                nums[k] = nums[right];
                temp = nums[right];
                right++;
            }
        }
        return k+1;
    }
}

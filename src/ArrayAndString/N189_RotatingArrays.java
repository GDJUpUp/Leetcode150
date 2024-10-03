package ArrayAndString;

public class N189_RotatingArrays {
    public static void main(String[] args) {

    }

    public static void rotateByReverseArray(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums,int begin,int end){
        int temp = 0;
        while(begin<end){
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}

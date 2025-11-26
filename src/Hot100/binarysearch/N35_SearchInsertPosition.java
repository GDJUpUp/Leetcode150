package Hot100.binarysearch;

public class N35_SearchInsertPosition {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid = (left+right)/2;
        while (nums[mid]!= target&&right>left){
            if (nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        if (nums[mid]>=target){
            return mid;
        }else {
            return mid+1;
        }
    }
}

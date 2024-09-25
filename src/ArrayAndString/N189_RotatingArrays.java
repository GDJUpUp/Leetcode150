package ArrayAndString;

public class N189_RotatingArrays {
    public static void main(String[] args) {

    }

//    使用新数组
    public static void rotateByNewArray(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i+(k% nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }

//    ToDo：学习java中数组操作
//    ToDo：切换k个位置
    public static void rotateByK(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i+(k% nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }

    //    ToDo：翻转数组
    public static void rotateByReverseArray(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i+(k% nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }
}

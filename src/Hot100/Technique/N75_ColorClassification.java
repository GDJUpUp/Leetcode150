package Hot100.Technique;

public class N75_ColorClassification {
    public static void main(String[] args) {
        sortColorsDutchFlag(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for(int i = red; i < red + white;i++){
            nums[i] = 1;
        }
        for(int i = red + white; i < nums.length;i++){
            nums[i] = 2;
        }

    }

    public static void sortColorsDutchFlag(int[] nums) {
        int redNext = 0;
        int whiteNext = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    int temp = nums[redNext];

                    nums[redNext] = nums[i];
                    nums[i] = temp;
                    if (redNext<whiteNext){
                        temp = nums[whiteNext];
                        nums[whiteNext] = nums[i];
                        nums[i] = temp;
                    }
                    redNext++;
                    whiteNext++;
                    break;
                case 1:
                    int temp2 = nums[whiteNext];
                    nums[whiteNext] = nums[i];
                    nums[i] = temp2;
                    whiteNext++;
                    break;
                default:
                    break;

            }
        }

    }

    public static void sortColorsDutchFlag2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }


        }

    }


}

package Hot100.TwoPointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15_ThreeSum {
    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(test);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSumOld(int[] nums) {
        int first,second,third;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (first = 0; first < nums.length - 2; first++) {
            second = first + 1;
            third = nums.length-1;
            while (second<third){
                int target = 0 - nums[first];
                while (nums[second]+nums[third]!=target&&second<third){
                    if (nums[second]+nums[third]<target){
                        second++;
                    }else {
                        third--;
                    }
                }
                if(nums[second]+nums[third] == target&&second<third){
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[first],nums[second],nums[third]));
                    res.add(list);
                    second++;
                    while (second!=nums.length&&nums[second-1] == nums[second]){
                        second++;
                    }
                }
            }
            while (first+1!=nums.length&&nums[first] == nums[first+1]){
                first++;
            }
        }
        return res;
    }


//    逻辑混乱，有待优化
    public static List<List<Integer>> threeSum(int[] nums) {
        int first,second,third;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (first = 0; first < nums.length - 2; first++) {
            second = first + 1;
            third = nums.length-1;
            while (second<third){
                int target = 0 - nums[first];
                while (nums[second]+nums[third]!=target&&second<third){
                    if (nums[second]+nums[third]<target){
                        second++;
                    }else {
                        third--;
                    }
                }
                if(second<third){
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[first],nums[second],nums[third]));
                    res.add(list);
                    second++;
                    while (second!=nums.length&&nums[second-1] == nums[second]){
                        second++;
                    }
                }
            }
            while (first+1!=nums.length&&nums[first] == nums[first+1]){
                first++;
            }
        }
        return res;
    }

}

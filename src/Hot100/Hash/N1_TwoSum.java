package Hot100.Hash;

import java.util.Arrays;

/**
 * 两数之和类
 * 
 * 该类实现了查找数组中两个数之和等于目标值的算法
 * 提供了查找两个数索引的方法
 * 
 * @author [作者]
 * @version 1.0
 * @since [版本]
 */
public class N1_TwoSum {

    /**
     * 主方法，用于测试twoSum方法
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 测试用例：数组和目标值
        int[] nums  = {2,7,11,15};
        int target = 18;
        // 调用twoSum方法查找两数之和
        int[] res = twoSum(nums,target);
        // 输出结果
        System.out.println(Arrays.toString(res));
    }

    /**
     * 在给定数组中查找两个数，使其和等于目标值，并返回这两个数的索引
     * 
     * 算法思路：
     * 1. 复制原数组并排序
     * 2. 使用双指针技术查找和为目标值的两个数
     * 3. 在原数组中找到这两个数的原始索引
     * 
     * 时间复杂度：O(n log n)，主要由排序操作决定
     * 空间复杂度：O(n)，需要额外数组存储排序后的数据
     * 
     * @param nums 给定的整数数组
     * @param target 目标和值
     * @return 包含两个元素索引的数组，如果未找到则返回默认值
     * @throws IllegalArgumentException 如果输入参数为null
     */
    public static int[] twoSum(int[] nums, int target) {
        // 参数校验
        if (nums == null) {
            throw new IllegalArgumentException("输入数组不能为null");
        }
        
        // 复制原数组以保留原始索引信息
        int[] numscopy = nums.clone();
        // 对复制的数组进行排序，为双指针查找做准备
        Arrays.sort(numscopy);
        
        // 初始化结果数组和双指针
        int[] res = new int[2];
        int left  = 0;
        int right = nums.length-1;
        
        // 使用双指针技术查找和为目标值的两个数
        while (numscopy[left]+numscopy[right]!= target && right>left){
            if (numscopy[left]+numscopy[right]>target){
                // 和大于目标值，右指针左移
                right--;
            }else {
                // 和小于目标值，左指针右移
                left++;
            }
        }
        
        // 在原数组中查找找到的两个数的原始索引
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == numscopy[left] || nums[i] == numscopy[right]){
                res[count] = i;
                count++;
            }
        }
        return res;
    }

}
package Hot100.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和类 - 优化版本
 * 
 * 该类实现了查找数组中两个数之和等于目标值的优化算法
 * 使用哈希表实现O(n)时间复杂度的解决方案
 * 
 * @author Lingma
 * @version 1.0
 * @since 1.0
 */
public class N1_TwoSumOptimized {
    
    /**
     * 主方法，用于测试twoSum方法
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 测试用例：数组和目标值
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        // 调用twoSum方法查找两数之和
        int[] res = twoSum(nums, target);
        // 输出结果
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
    
    /**
     * 在给定数组中查找两个数，使其和等于目标值，并返回这两个数的索引
     * 
     * 算法思路：
     * 1. 使用哈希表存储已遍历过的元素及其索引
     * 2. 对于每个元素，计算其与目标值的差值
     * 3. 在哈希表中查找该差值是否存在
     * 4. 如果存在，则找到答案；否则将当前元素存入哈希表
     * 
     * 时间复杂度：O(n)，只需要遍历一次数组
     * 空间复杂度：O(n)，需要额外的哈希表存储元素
     * 
     * @param nums 给定的整数数组
     * @param target 目标和值
     * @return 包含两个元素索引的数组
     * @throws IllegalArgumentException 如果输入参数为null或找不到满足条件的两个数
     */
    public static int[] twoSum(int[] nums, int target) {
        // 参数校验
        if (nums == null) {
            throw new IllegalArgumentException("输入数组不能为null");
        }
        
        // 创建哈希表存储元素值和对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算目标值与当前元素的差值
            int complement = target - nums[i];
            
            // 在哈希表中查找差值是否存在
            if (map.containsKey(complement)) {
                // 如果存在，返回差值的索引和当前索引
                return new int[] {map.get(complement), i};
            }
            
            // 将当前元素及其索引存入哈希表
            map.put(nums[i], i);
        }
        
        // 如果未找到满足条件的两个数，抛出异常
        throw new IllegalArgumentException("数组中不存在和为目标值的两个数");
    }
}
from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        start = 0
        end = 0
        sum = 0
        ans = len(nums)+1
        while end < len(nums):
            sum += nums[end]
            if sum >= target:
                # print("开始是{}，结束是{},总和是{}".format(start,end,sum))
                ans = min(ans,end-start+1)
                sum -= (nums[start] + nums[end])
                start += 1
                end= max(end,start)
            else:
                end += 1
        if ans>len(nums):
            return 0
        else:
            return ans

class Solution2:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # print(target)
        sum = [0] * len(nums)
        for i in range(0,len(nums)):
            for j in range(i,len(nums)):
                sum[j] = sum[j] + nums[j-i]
                if sum[j] >= target:
                    return i +1
        return 0
    
if __name__ == '__main__':
    solution = Solution()
    numbers = [1,2,3,4,5]
    target = 15
    print(solution.minSubArrayLen(target,numbers))


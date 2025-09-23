from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)
        ans = []
        for i in range(0,len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if nums[i] + nums[j] + nums[k] == 0:
                    temp = [nums[i],nums[j],nums[k]]
                    ans.append(temp)
                    while j + 1 < k :
                        if nums[j+1] != nums[j]:
                            j += 1
                            break
                        else:
                            j += 1
                    else:
                        break
                while nums[i] + nums[j] + nums[k] > 0:
                    k -= 1
                    if k == j:
                        break
                while nums[i] + nums[j] + nums[k] < 0:
                    j += 1
                    if k == j:
                        break
        return ans


if __name__ == '__main__':
    solution = Solution()
    nums = [0,1,1]
    three_sum = solution.threeSum(nums)
    print(three_sum)

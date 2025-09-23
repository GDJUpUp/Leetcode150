from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers)-1
        while left<right :
            if numbers[left]  + numbers[right] == target:
                break
            while numbers[left]  + numbers[right] < target:
                left += 1
            while numbers[left] + numbers[right] > target:
                right -= 1
        return left+1 ,right+1

if __name__ == '__main__':
    solution = Solution()
    numbers = [2, 7, 11, 15]
    target = 9
    print(solution.twoSum(numbers,target))

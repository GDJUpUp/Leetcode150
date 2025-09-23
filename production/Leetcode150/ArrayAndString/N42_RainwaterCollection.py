from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        sumRain1,left = self.trapOnce(height)
        height2 = height[left:]
        height2.reverse()
        sumRain2,left = self.trapOnce(height2)
        return  sumRain1+sumRain2

    def trapOnce(self, height: List[int]) -> int:
        left,leftHigh,sumRain = 0,0,0
        for i in range(0,len(height)):
            if leftHigh == 0 and height[i] != 0:
                leftHigh = height[i]
                left = i
                continue
            elif leftHigh == 0 and height[i] == 0:
                continue
            if height[i] >= leftHigh:
                for j in range(left,i):
                    sumRain += leftHigh-height[j]
                left = i
                leftHigh = height[i]
                continue
        return  sumRain,left


if __name__ == '__main__':
    height = [2,0,2]
    solution = Solution()
    print(solution.trap(height))


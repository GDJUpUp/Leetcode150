from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 1:
            return 1;
        ans = []
        ans.append(1)
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                ans.append(ans[i-1]+1)
            else:
                ans.append(1)
        ans[len(ratings)-1] = max(ans[len(ratings)-1],1)
        for i in  range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                ans[i] = max(ans[i+1]+1,ans[i])
        return sum(ans)

if __name__ == '__main__':
    solution = Solution()
    print(solution.candy([1,3,4,5,2]))



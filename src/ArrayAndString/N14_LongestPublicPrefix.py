from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = ""
        for i in range(0,201):
            if i >= len(strs[0]):
                return prefix
            s = strs[0][i]
            for j in range(0,len(strs)):
                if i >= len(strs[j]) or strs[j][i] != s:
                    return prefix
            prefix += s
        return prefix


if __name__ == '__main__':
    solution = Solution()
    strs1 = ["flower","flow","flight"]
    strs2 = ["dog","racecar","car"]
    print(solution.longestCommonPrefix(strs1))
    print(solution.longestCommonPrefix(strs2))

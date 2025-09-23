class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        return haystack.find(needle)

if __name__ == '__main__':
    solution = Solution()
    print(solution.strStr("sadbutsad","sad"))
    print(solution.strStr("leetcode","leeto"))
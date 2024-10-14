class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = [i for i in s if i.isalpha() or i.isnumeric()]
        s = "".join(s)
        s = s.lower()
        for i in range(0,len(s)):
            if s[i] != s[len(s)-1-i]:
                return False
        return True

if __name__ == '__main__':
    solution = Solution()

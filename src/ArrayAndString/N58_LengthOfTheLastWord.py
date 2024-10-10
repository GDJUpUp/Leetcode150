class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip();
        words = s.split(" ")
        return len(words[len(words)-1])

if __name__ == '__main__':
    solution = Solution()
    s1 = "Hello World"
    s2 = "   fly me   to   the moon  "
    s3 = "luffy is still joyboy"
    print(solution.lengthOfLastWord(s1))
    print(solution.lengthOfLastWord(s2))
    print(solution.lengthOfLastWord(s3))
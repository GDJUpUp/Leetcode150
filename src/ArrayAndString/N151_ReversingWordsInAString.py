class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        s_split = s.split(" ")
        s_split = list(reversed(s_split))
        ans = ""
        for i in range(len(s_split)):
            if i != len(s_split)-1 and s_split[i] != "":
                ans += s_split[i]+" "
            else:
                ans += s_split[i]
        return ans


if __name__ == '__main__':
    solution = Solution()
    s1 = "the sky is blue"
    s2 = "  hello world  "
    s3 = "a good   example"
    print(solution.reverseWords(s1))
    print(solution.reverseWords(s2))
    print(solution.reverseWords(s3))

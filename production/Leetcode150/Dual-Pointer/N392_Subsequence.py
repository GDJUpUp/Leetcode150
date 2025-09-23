class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        p1 = 0
        p2 = 0
        if s == "":
            return True
        while p2 <len(t):
            while p1 < len(s):
                if s[p1] == t[p2]:
                    p1+=1
                    break
                break
            p2 += 1
            if p1 == len(s):
                return True
        return False



if __name__ == '__main__':
    solution = Solution()
    s = "abc"
    t = "ahbgdc"
    print(solution.isSubsequence(s,t))

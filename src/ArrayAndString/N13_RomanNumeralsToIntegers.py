class Solution:
    def romanToInt(self, s: str) -> int:
        d = {"I": 1, "V": 5,"X": 10,"L":50,"C":100,"D":500,"M":1000}
        sum = d[s[len(s)-1]]
        if(len(s)==1):
            return sum
        for i in range(len(s)-2,-1,-1):
            if d[s[i]]<d[s[i+1]]:
                sum-=d[s[i]]
            else:
                sum+= d[s[i]]
        return sum

if __name__ == '__main__':
    s1 = "III"
    s2 = "IV"
    s3 = "IX"
    s4 = "LVIII"
    s5 = "MCMXCIV"
    solution = Solution()
    print(solution.romanToInt(s1))
    print("-------------------")
    print(solution.romanToInt(s2))
    print("-------------------")
    print(solution.romanToInt(s3))
    print("-------------------")
    print(solution.romanToInt(s4))
    print("-------------------")
    print(solution.romanToInt(s5))
    print("-------------------")

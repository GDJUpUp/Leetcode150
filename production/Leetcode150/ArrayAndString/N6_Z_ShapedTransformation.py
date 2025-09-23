class Solution:
    def convert(self, s: str, numRows: int) -> str:
        ans = ""
        for i in range(0,numRows):
            location = 0 + i
            flag = True
            # print("i是{}".format(i))
            if len(s)  == 1 or numRows == 1:
                return s
            while location < len(s):
                # print(location)
                # return ans
                if flag == True:
                    if i == numRows -1:
                        flag = False
                        continue
                    ans += s[location]
                    location += 2*(numRows - (i+1))
                    if i == 0:
                        continue
                    flag = False

                else:
                    ans += s[location]
                    location += 2*i
                    flag = True
        return ans

if __name__ == '__main__':
    solution = Solution()
    s1 = "PAYPALISHIRING"
    numRows1 = 3
    ans1 = "PAHNAPLSIIGYIR"
    s2 = "PAYPALISHIRING"
    numRows2 = 4
    ans2 = "PINALSIGYAHRPI"
    s3 = "AB"
    numRows3 = 1
    ans3 = "A"
    print(solution.convert(s1,numRows1))
    print(solution.convert(s2,numRows2))
    print(solution.convert(s3,numRows3))


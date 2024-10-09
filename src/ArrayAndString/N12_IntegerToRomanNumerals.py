class Solution:
    def intToRoman(self, num: int) -> str:
        d = {1:"I", 5:"V" ,10:"X",50:"L",100:"C",500:"D",1000:"M",4:"IV",9:"IX",40:"XL",90:"XC",400:"CD",900:"CM",}
        s = ""
        for i in range(3,-1,-1):
            magnitude = pow(10,i)

            surplus = num%pow(10,i)
            maxBit = (num - surplus)/magnitude
            if maxBit == 1 or maxBit == 4 or maxBit == 5 or maxBit == 9:
                s += d[maxBit*magnitude]
            elif maxBit > 5:
                s += d[5*magnitude]
                for j in range(0,int(maxBit) - 5):
                    s+=d[1*magnitude]
            else:
                for j in range(0,int(maxBit)):
                    s+=d[1*magnitude]
            num -= maxBit*magnitude
        return s

if __name__ == '__main__':
    solution = Solution()
    print(solution.intToRoman(3749))

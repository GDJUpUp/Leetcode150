from typing import List

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ansList = []
        i = 0
        while i < len(words):
            length = 0
            justwordlength = 0
            if i == len(words)-1 and length == 0:
                ansList.append(words[i]+" "*(maxWidth - len(words[i])))
                i = i + 1
            else:
                left = i
                while length <= maxWidth:
                    # 加入该单词，超过最大行长度
                    if length + len(words[left]) >maxWidth:
                        currentline = ""
                        count = left - i
                        if count == 1:
                            currentline += words[i]+" "*(maxWidth - len(words[i]))
                            ansList.append(currentline)
                        else:
                            templength = maxWidth - justwordlength
                            rightspace = int(templength/(count-1))
                            leftcount = templength % (count-1)
                            for j in range(i,i+leftcount):
                                currentline += words[j] + " "*(rightspace+1)
                            for j in range(i + leftcount,left-1):
                                currentline += words[j] + " "*rightspace
                            currentline += words[left-1]
                            ansList.append(currentline)
                        i = left
                        break
                    # 加入该单词，等于最大行长度
                    elif length + len((words[left])) == maxWidth:
                        currentline = ""
                        for j in range(i ,left):
                            currentline += words[j] + " "
                        currentline += words[left]
                        ansList.append(currentline)
                        i = left + 1
                        break
                    #  加入该单词，小于最大行长度
                    else:
                        justwordlength += len(words[left])
                        length += len(words[left])+1
                        left += 1
                        if left >= len(words):
                            currentline = ""
                            for j in range(i , left):
                                currentline += words[j] + " "
                            currentline += " "*(maxWidth - len(currentline))
                            ansList.append(currentline)
                            i = left
                            break
        return  ansList

if __name__ == '__main__':
    solution = Solution()
    words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
    maxWidth = 20
    justify = solution.fullJustify(words, maxWidth)
    for  i in range(0,len(justify)):
        print(justify[i])
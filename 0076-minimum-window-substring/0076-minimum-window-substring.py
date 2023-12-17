class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "": return ""

        haveChars, needChars = {}, {}

        for c in t:
            needChars[c] = 1 + needChars.get(c, 0)
        
        haveCount, needCount = 0, len(needChars)

        finalLeft, finalRight = -1, -1
        windowSize = float("infinity")

        left = 0

        for right in range(len(s)):

            currChar = s[right]
            haveChars[currChar] = haveChars.get(currChar, 0) + 1

            if currChar in needChars and haveChars[currChar] == needChars[currChar]:
                haveCount += 1
            
            while haveCount == needCount:
                if windowSize > (right - left + 1):
                    windowSize = (right - left + 1)
                    finalLeft = left
                    finalRight = right

                currChar = s[left]
                haveChars[currChar] -= 1
                if currChar in needChars and haveChars[currChar] < needChars[currChar]:
                    haveCount -= 1
                
                left += 1
            
            right += 1
        
        return s[finalLeft : finalRight + 1]
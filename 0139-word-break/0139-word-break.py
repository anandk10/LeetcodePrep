class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        
        def solution() -> bool:
            # DP table with all False
            dp = [False] * (len(s) + 1)
            dp[len(s)] = True # empty input string is always True
            
            # Iterate from the end of the string s
            for i in range(len(s) - 1, -1, -1):
                for w in wordDict:
                    # the ith index + the length of word w in dict
                    # should at least be number of characters until
                    # the end of the string
                    # and then slicing the string s starting at i
                    # and adding the end index as i + len(w) and match it with w
                    if i + len(w) <= len(s) and s[i : i + len(w)] == w:
                        # when it was leetcode with dict as leet and code
                        # i = 4 ; code = code = dp[4] = dp [4 + 4] = dp[8] = True
                        # i = 0 ; leet = leet = dp[0] = dp [0 + 4] = dp [4] = True
                        dp[i] = dp[i + len(w)]
                    if dp[i]:
                        # once we find the match break from match in the word dict
                        break
            return dp[0];
            
        return solution()
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        cur = []

        def dfs(i, cur, total):
            if total == target:
                res.append(cur.copy())
                return
            
            if i >= len (candidates) or total > target:
                return

            cur.append(candidates[i])
            # include occurrences of i
            dfs(i, cur, total + candidates[i])

            cur.pop()
            # cant include any occurrences of i
            dfs(i + 1, cur, total)

        dfs(0, cur, 0)
        return res



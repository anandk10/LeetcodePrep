class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        res = []
        # board = [ ["."] * n ] * n
        board = [ ["."] * n for i in range(n) ]

        # we maintain these sets to indicate if Q can attack
        # col indicates that no further Q can be placed in the same column
        # posDiag indicates the diagonal going from lower left to top right
        #     if we move in that direction then the sum of row and column index stays constant
        # negDiag indicates the diagonal going from upper left to lower right
        #     if we move in that direction then the difference between row and column stays constant

        col = set()
        posDiag = set()
        negDiag = set()

        def backtrack(r):
            if r == n:
                # add to the result
                copy = ["".join(row) for row in board]
                res.append(copy)
                return

            for c in range(n):
                # skip the column c if its in any of these sets : col, posDiag, negDiag
                if c in col or (r + c) in posDiag or (r - c) in negDiag:
                    continue
                
                # since we are choosing this column c, lets update the sets
                col.add(c)
                posDiag.add(r + c)
                negDiag.add(r - c)

                # place the Q
                board[r][c] = "Q"

                # we have found a column where the Q can be placed
                # go to the next row
                backtrack(r + 1)

                # clean up the set and remove the references for column c
                # because the next column shouldn't see the earlier state
                col.remove(c)
                posDiag.remove(r + c)
                negDiag.remove(r - c)
                board[r][c] = "."
        
        backtrack(0)
        return res




        
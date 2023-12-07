class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

      # constraints to check for a valid sudoku are that
      # considering the present board values (not considering the values for empty spaces)
      # so maintaining a HashSet for row values
      # a HashSet for column values
      # and then finally a HashSet for grid

      # Grid HashSet is little complex because here we try to maintain
      # the key as an operation of row and column index that could map to the grid

      # Sudoko is a 9x9 board where there are 9 3x3 grids in it.
      #    0  1  2 
      # 0 [] [] []
      # 1 [] [] []
      # 2 [] [] []
      
      # Every [] is a 3x3 grid.
      # So this HashSet would have to ensure that elements are unique within each grid
      # the calculation we will resort to is row // 3, col // 3 to map to the grid value.

      ROWS = len(board)
      COLS = len(board[0])

      colSet = collections.defaultdict(set) # key is the column number
      rowSet = collections.defaultdict(set) # key is the row number
      gridSet = collections.defaultdict(set) #key is a pair of (r // 3, c // 3)


      for r in range(ROWS):
        for c in range(COLS):
          # process value if not "."
          if board[r][c] == ".":
            continue
          print("Checking for " + str(board[r][c]))
          if (board[r][c] in rowSet[r] 
              or board[r][c] in colSet[c] 
              or board[r][c] in gridSet[(r//3, c//3)]):
              print("----" + str(r) + ", " +str(c))
              return False
          rowSet[r].add(board[r][c])
          # print(rowSet)
          colSet[c].add(board[r][c])
          # print(colSet)
          gridSet[(r//3, c//3)].add(board[r][c])
          
          # print(gridSet)
      return True

      
        

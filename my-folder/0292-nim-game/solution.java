class Solution {
    public boolean canWinNim(int n) {
        
        /**
        
           base condition to understand is
           if n == 4 then player 1 always loses
           1 2 3 4
           player1 picks 1 player2 picks 2-4
                        1-2             3-4
                        1-3               1
            in any case player1 loses
            
            so if input is multiple of 4, then player1 will
            always lose
           
         */
        
        return n % 4 != 0;
        
        
        
    }
}

class Solution {
    
    
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mirror = new HashMap<>();
        mirror.put('0','0');
        mirror.put('1','1');
        mirror.put('6','9');
        mirror.put('8','8');
        mirror.put('9','6');
        
        
        int lower = 0;
        int upper = num.length() - 1;
        
        while (lower <= upper) {
            char lowerCh = num.charAt(lower);
            if(mirror.get(lowerCh) == null) { return false; }
            
            if (mirror.get(lowerCh) != num.charAt(upper)) {
                return false;
            }
            
            lower++; upper--;
        }
        return true;
        /**
        <0,0> , <1,1>, <6,9> <8,8> <9,6>
        the chars should be in [0,1,6,8,9]
                lower       upper
                mirror[lower] == num.charAt(upper);
                
                10696901
                 |   |
                 
                69169
                
        else false
        
        
        */
    }
}

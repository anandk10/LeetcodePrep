class Solution {
    public int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int num1 = 0;
        int num2 = 1;
        int num3 = 1;

        int num4 = 0;
        for(int i = 3; i <= n; i++) {
            num4 = num1 + num2 + num3;
            int temp1 = num3;
            num3 = num4;
            int temp2 = num2;
            num2 = temp1; // prior num3
            num1 = temp2; // prior num2
        }
        return num4;
        
    }
}

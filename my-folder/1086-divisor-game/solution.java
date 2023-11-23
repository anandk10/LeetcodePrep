class Solution {
    public boolean divisorGame(int n) {
        // n % x == 0
        // n even then multiple choices
        // n odd then there's no value other than n or 1
        return n % 2 == 0;

    }
}

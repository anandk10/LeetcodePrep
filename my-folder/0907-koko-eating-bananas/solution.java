class Solution {
    private static int maxBananas(int[] piles) {
        return Arrays.stream(piles).max().orElse(0);
    }

    private static boolean isRightKValue(final int[] piles, final int mid, final int h) {
        int sumHour = 0;
        for (int i = 0; i < piles.length; i++) {
            sumHour += (int) Math.ceil((double) piles[i] / mid);
            if (sumHour > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        // Solution 1: Brute force
        // for all k values try checking if pile of bananas get consumed in h hours
        // int maxBananas = maxBananas(piles);
        // int k = 1;
        // for (; k < maxBananas; k++) {
        //     int sumHour = 0;
        //     for (int i = 0; i < piles.length; i++) {
        //         sumHour += piles[i] < k ? 1 : (int) Math.ceil( (double) piles[i] / k );
        //         if (sumHour > h) break;
        //     }
        //     if (sumHour <= h) break;
        // }
        // return k;

        int lower = 1;
        int upper = maxBananas(piles);
        int currentK = 1;
        while(lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            // if mid == target
            if (isRightKValue(piles, mid, h)) {
                //  even if we found the right k, we 
                // need to find the minimum k
                // so move to the left
                upper = mid - 1;
                currentK = mid;
            } else {
                // maybe the k is not enough
                // so we move to the right
                lower = mid + 1;
            }
        }
        return currentK;


    }
}

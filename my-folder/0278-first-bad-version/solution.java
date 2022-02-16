/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int upper = n - 1;
        int lower = 0;
        while ( lower <= upper ) {
            int mid = (upper - lower) / 2 + lower;
            if ( isBadVersion(mid) ) upper = mid - 1;
            else lower = mid + 1;
        }
        return upper + 1;
    }
}

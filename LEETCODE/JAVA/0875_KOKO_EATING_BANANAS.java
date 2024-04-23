class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // Peform a binary search on the eating speeds. On each iteration, check if Koko
        // can eat all the bananas in the given time. If she can, search for a lesser eating
        // speed, otherwise search for a sufficient eating speed.
        
        int left = 1;
        int right = 1;
        
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
        
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                right = mid;
            }
            else {
                left = mid + 1;
            }            
        }
        
        return right;
    }
}
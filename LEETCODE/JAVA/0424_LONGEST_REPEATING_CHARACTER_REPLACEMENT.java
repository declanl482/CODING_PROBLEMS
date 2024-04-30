class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max = 0;
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            max = Math.max(max, freq[s.charAt(right) - 'A']);
            
            // Move the left side of the window in search of a longer substring.
            while (right - left - max + 1 > k) {
                freq[s.charAt(left++) - 'A']--;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
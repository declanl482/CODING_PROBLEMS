class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        // s2 cannot contain a permutation of s1 if there are more characters in s1 than in s2
        if (n > m) {
            return false;
        }
        
        // compute the frequencies for each of the n characters in s1
        int[] freq1 = new int[26];
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }
        
        // compute the frequencies for each of the m characters in s2
        // we will be sliding an n-sized window over all the characters in the string until the end,
        // searching for a permutation of s1, from left to right
        int[] freq2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            // shrink the window while there IS a repeating character in the current window substring
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left++));
            }

            // advance the window for the current character
            charSet.add(s.charAt(right));

            // maximize the length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
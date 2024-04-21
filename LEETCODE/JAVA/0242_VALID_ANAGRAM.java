class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> characterFrequencies = new HashMap<Character, Integer>();
        
        // Load up the character-frequency mappings using the first string.
        for (char ch : s.toCharArray()) {
            characterFrequencies.put(ch, characterFrequencies.getOrDefault(ch, 0) + 1);
        }
        
        // Unload the character-frequency mappings using the second string.
        for (char ch : t.toCharArray()) {
            if (characterFrequencies.getOrDefault(ch, 0) == 0) {
                return false;
            }
            
            characterFrequencies.put(ch, characterFrequencies.getOrDefault(ch, 0) - 1);
        }
        
        // Check if the two strings are anagrams.
        for (int freq : characterFrequencies.values()) {
            if (freq != 0) {
                return false;
            }
        }
        
        return true;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // For each string in the array
            // Convert the string to a unique anagram key
            // Add the string to the list associated with its unique anagram key
        
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String anagramKey = String.valueOf(strChars);
   
            anagramMap.computeIfAbsent(anagramKey, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, "", 0, 0, n);
        return combinations;
    }
    
    private void backtrack(List<String> list, String curStr, int open, int close, int max) {
        if (curStr.length() == 2 * max) {
            list.add(curStr);
        }
        
        if (open < max) {
            backtrack(list, curStr + "(", open + 1, close, max);
        }
        
        if (close < open) {
            backtrack(list, curStr + ")", open, close + 1, max);
        }
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        
        int[] res = new int[temperatures.length];
        
        for (int cur = 0; cur < temperatures.length; cur++) {
            while (!stack.isEmpty() && temperatures[cur] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = cur - prev;
            }
            stack.push(cur);
        }
        
        return res;
    }
}
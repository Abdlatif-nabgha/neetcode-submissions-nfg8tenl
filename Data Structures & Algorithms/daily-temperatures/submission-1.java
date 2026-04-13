class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int len = temperatures.length;
        int[] R = new int[len];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (s.isEmpty()) {
                s.push(i);
            } else {
                while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                    int j = s.pop();
                    R[j] = i-j;
                } 
                s.push(i);
            }
        }
        return R;
    }
}

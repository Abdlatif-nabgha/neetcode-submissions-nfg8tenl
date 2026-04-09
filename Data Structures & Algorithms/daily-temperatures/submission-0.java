class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int len = temperatures.length;
        int[] R = new int[len];

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    R[i] = j-i;
                    break;
                }
            }
        }
        return R;
    }
}

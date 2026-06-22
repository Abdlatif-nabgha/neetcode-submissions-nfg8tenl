class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0;
        Map<Character, Integer> counter = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            counter.merge(c,1, Integer::sum);
            while (counter.get(c) > 1) {
                counter.compute(
                    s.charAt(l), 
                    (key, count) -> 
                        count == null || count == 1 ? null : count - 1);
                l++;
            }
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}

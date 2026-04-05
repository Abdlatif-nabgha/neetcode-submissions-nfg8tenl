class Solution {
    public boolean isAnagram(String s, String t) {
        // Early exit if lengths are different
        if (s.length() != t.length()) {
            return false;
        }
        
        // Array to store character frequencies
        // Index 0 = 'a', Index 1 = 'b', ..., Index 25 = 'z'
        int[] count = new int[26];
        
        // Single pass: increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        // If all counts are 0, strings are anagrams
        for (int freq : count) {
            if (freq != 0) {
                return false;
            }
        }
        
        return true;
    }
}
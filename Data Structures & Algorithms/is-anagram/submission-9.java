class Solution {
    public boolean isAnagram(String s, String t) {

        // verify is 2 strings have the same length
        if (s.length() != t.length()) return false;

        // create an array to store lowercase letters in it
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // check if there is any non-zero element in the array
        for(int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}

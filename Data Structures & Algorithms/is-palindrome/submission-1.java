class Solution {

    public boolean isPalindrome(String s) {
        // your palindrome logic here
        int l = 0, r = s.length() - 1;
        while (l < r) {

            // skip non-alphanumeric characters
            while (l < r && !isAlphanumeric(s.charAt(l))) l++;
            while (l < r && !isAlphanumeric(s.charAt(r))) r--;

            // check if the characters from both ends match
            if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return String.valueOf(c).matches("^[A-Za-z0-9]$");
    }
}
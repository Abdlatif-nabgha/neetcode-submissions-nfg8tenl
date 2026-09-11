class Solution {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Move left pointer forward if it's not a letter or digit
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            // Move right pointer backward if it's not a letter or digit
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } 

            // Convert both to lowercase and compare
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            
            l++;
            r--;
        }

        return true;
    }
}

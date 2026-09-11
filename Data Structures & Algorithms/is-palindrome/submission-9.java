
class Solution {
    public boolean isPalindrome(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // Step 1: Push all valid alphanumeric characters onto the stack in lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toLowerCase(ch));
            }
        }

        // Step 2: Compare the original sequence with the reversed stack sequence
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                
                // If the top of the stack doesn't match the current forward character
                if (stack.pop() != lowerCh) {
                    return false;
                }
            }
        }

        return true;
    }
}

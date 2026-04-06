class Solution {
    private static boolean validChar(char a, char c) {
        if (a == '(' && c == ')' || a == '[' && c == ']' || a == '{' && c == '}') return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                else {
                    char a = stack.pop();
                    if (!validChar(a, c)) return false;
                }

            } else {
                stack.push(c);    
            }
            
        }

        return stack.isEmpty();
    }
}

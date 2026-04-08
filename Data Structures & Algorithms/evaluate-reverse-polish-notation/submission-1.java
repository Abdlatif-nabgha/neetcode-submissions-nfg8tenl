class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer sum = 0;

        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer b = stack.pop();
                Integer a = stack.pop();
                sum = applyOperator(a, b, s);
                stack.push(sum);
            }
        }
        return stack.pop();
    }
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    private static Integer applyOperator(Integer a, Integer b, String op) {
        Integer result = 0;
        if ("+".equals(op)) {
            result = a + b;
        }
        else if ("-".equals(op)) {
            result = a - b;
        }
        else if ("*".equals(op)) {
            result = a * b;
        }
        else if ("/".equals(op)) {
            if (b==0) {
                throw new ArithmeticException("Division by zero");
            }
            result = a / b;
        }
        return result;
    }
}

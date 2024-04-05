import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                // Thing to remember difference between capital and small of alphabet in ascii
                // is 32
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder resSB = new StringBuilder();
        while (!stack.isEmpty())
            resSB.append(stack.pop());
        return resSB.reverse().toString();
    }
}
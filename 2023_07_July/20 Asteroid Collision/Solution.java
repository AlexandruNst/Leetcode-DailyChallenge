import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0)
                stack.push(asteroid);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek())
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
                else if (Math.abs(asteroid) == stack.peek())
                    stack.pop();
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();

        return res;
    }
}
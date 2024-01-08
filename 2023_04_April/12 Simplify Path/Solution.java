import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : splitPath) {
            if (dir.equals(".") || dir.equals(""))
                continue;
            else if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(dir);
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty())
            return "/";

        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.toString();
    }
}
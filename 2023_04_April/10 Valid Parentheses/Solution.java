import java.util.*;

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return false;
        if (s.length() % 2 != 0)
            return false;

        Map<Character, Character> correspondence = new HashMap<>();
        correspondence.put('(', ')');
        correspondence.put('[', ']');
        correspondence.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (isOpeningBracket(bracket, correspondence)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty())
                    return false;
                char lastBracket = stack.pop();
                if (!isCorrespondingBracket(bracket, lastBracket, correspondence))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char bracket, Map<Character, Character> correspondence) {
        return correspondence.containsKey(bracket);
    }

    private boolean isCorrespondingBracket(char bracket, char lastBracket, Map<Character, Character> correspondence) {
        return correspondence.get(lastBracket) == bracket;
    }
}
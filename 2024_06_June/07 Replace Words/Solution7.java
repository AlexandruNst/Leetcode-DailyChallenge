import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>();
        List<Integer> lengths = new ArrayList<>();

        for (String word : dictionary) {
            lengths.add(word.length());
            roots.add(word);
        }

        Collections.sort(lengths);

        String[] splitSentence = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : splitSentence) {
            boolean found = false;
            for (int length : lengths) {
                if (length < word.length()) {
                    String root = word.substring(0, length);
                    if (roots.contains(root)) {
                        res.append(root);
                        found = true;
                        break;
                    }
                }
            }
            if (!found)
                res.append(word);
            res.append(" ");
        }

        return res.toString().trim();

    }
}
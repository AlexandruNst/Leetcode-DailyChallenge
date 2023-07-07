class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int trues = 0, falses = 0, max = 0, len = 0, start = 0, end = 0;
        char[] answers = answerKey.toCharArray();

        while (end < answers.length) {
            if (answers[end] == 'T')
                trues++;
            if (answers[end] == 'F')
                falses++;
            max = Math.max(max, Math.max(trues, falses));

            while (end - start + 1 - max > k) {
                if (answers[start] == 'T')
                    trues--;
                if (answers[start] == 'F')
                    falses--;
                start++;
            }

            len = Math.max(len, end - start + 1);
            end++;
        }

        return len;
    }
}
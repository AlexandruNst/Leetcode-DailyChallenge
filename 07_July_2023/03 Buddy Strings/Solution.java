class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int[] sFreq = new int[26];
        int[] goalFreq = new int[26];
        int diffs = 0;

        char[] sChars = s.toCharArray();
        char[] goalChars = goal.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char sChar = sChars[i];
            char goalChar = goalChars[i];

            if (sChar != goalChar)
                diffs++;
            if (diffs > 2)
                return false;

            sFreq[sChar - 'a']++;
            goalFreq[goalChar - 'a']++;
        }

        if (diffs == 0)
            return isOneAtLeastTwo(sFreq);
        return areFreqsEqual(sFreq, goalFreq);
    }

    private boolean areFreqsEqual(int[] sFreq, int[] goalFreq) {
        for (int i = 0; i < sFreq.length; i++) {
            if (sFreq[i] != goalFreq[i])
                return false;
        }

        return true;
    }

    private boolean isOneAtLeastTwo(int[] sFreq) {
        for (int freq : sFreq) {
            if (freq >= 2)
                return true;
        }

        return false;
    }
}
class Solution {
    final int LOWERCASE_A_ASCII_VALUE = 97;

    public boolean checkInclusion(String s1, String s2) {
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        int windowLength = s1.length();
        boolean found = false;
        int[] s1Freq = new int[26];

        for (char c : s1CharArr) {
            s1Freq[c - LOWERCASE_A_ASCII_VALUE]++;
        }

        for (int i = 0; i <= s2.length() - windowLength; i++) {
            found = found || checkWindow(createArrCopy(s1Freq), s2CharArr, i, windowLength);
            if (found)
                break;
        }

        return found;
    }

    private boolean checkWindow(int[] s1Freq, char[] s2CharArr, int start, int windowLength) {
        for (int i = 0; i < windowLength; i++) {
            char c = s2CharArr[start + i];
            int cPos = c - LOWERCASE_A_ASCII_VALUE;
            if (s1Freq[cPos] <= 0)
                return false;
            else
                s1Freq[cPos]--;
        }
        return checkArrAllZeros(s1Freq);
    }

    private boolean checkArrAllZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    private int[] createArrCopy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
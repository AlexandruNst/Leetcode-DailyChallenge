class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                currVowels++;
        }
        maxVowels = currVowels;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                currVowels++;
            if (isVowel(s.charAt(i - k)))
                currVowels--;
            maxVowels = Math.max(maxVowels, currVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
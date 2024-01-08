class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();

        // for(String w: word1) sb1.append(w);
        // for(String w: word2) sb2.append(w);

        // return sb1.toString().equals(sb2.toString());

        //////////////////////////////////////////////////////////

        int i1 = 0;
        int i2 = 0;
        int w1 = 0;
        int w2 = 0;

        while (w1 < word1.length && w2 < word2.length) {
            if (word1[w1].charAt(i1) != word2[w2].charAt(i2))
                return false;
            i1++;
            i2++;
            if (i1 >= word1[w1].length()) {
                w1++;
                i1 = 0;
            }

            if (i2 >= word2[w2].length()) {
                w2++;
                i2 = 0;
            }
        }

        if ((w1 == word1.length - 1 && w2 != word2.length - 1) ||
                (w1 != word1.length - 1 && w2 == word2.length - 1))
            return false;

        return true;
    }
}
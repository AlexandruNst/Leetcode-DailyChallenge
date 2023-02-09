import java.util.HashSet;

class Solution {
    public long distinctNames(String[] ideas) {
        final int LETTERS_IN_ALPHABET = 26;

        HashSet<String>[] suffixes = new HashSet[LETTERS_IN_ALPHABET];
        long result = 0;

        for (int i = 0; i < 26; i++) {
            suffixes[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            char firstChar = idea.charAt(0);
            String suffix = idea.substring(1);

            suffixes[firstChar - 'a'].add(suffix);
        }

        for (int i = 0; i < LETTERS_IN_ALPHABET - 1; i++) {
            for (int j = i + 1; j < LETTERS_IN_ALPHABET; j++) {
                HashSet<String> setOne = suffixes[i];
                HashSet<String> setTwo = suffixes[j];

                int suffixesInCommon = 0;
                for (String suffix : setOne) {
                    if (setTwo.contains(suffix))
                        suffixesInCommon++;
                }

                int sizeSetOneAfter = setOne.size() - suffixesInCommon;
                int sizeSetTwoAfter = setTwo.size() - suffixesInCommon;

                result += sizeSetOneAfter * sizeSetTwoAfter * 2; // because pairs go both ways
            }
        }

        return result;
    }
}
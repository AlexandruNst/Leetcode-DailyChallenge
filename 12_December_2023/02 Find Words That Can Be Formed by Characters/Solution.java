class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsCharFreq = new int[26];
        for (char c : chars.toCharArray())
            charsCharFreq[c - 'a']++;

        int res = 0;
        for (String word : words)
            if (isGood(word, charsCharFreq.clone()))
                res += word.length();
        return res;
    }

    private boolean isGood(String word, int[] charsCharFreq) {
        for (char c : word.toCharArray()) {
            if (charsCharFreq[c - 'a'] == 0)
                return false;
            charsCharFreq[c - 'a']--;
        }
        return true;
    }
}

// class Solution {
// public int countCharacters(String[] words, String chars) {
// int res = 0;
// Map<Character, Integer> charsCharFreq = getCharFreq(chars);
// for(String word: words) if(isGood(word, charsCharFreq)) res += word.length();
// return res;
// }

// private boolean isGood(String word, Map<Character, Integer> charsCharFreq){
// Map<Character, Integer> wordCharFreq = getCharFreq(word);

// for(Character c: wordCharFreq.keySet()){
// if(!charsCharFreq.containsKey(c) || wordCharFreq.get(c) >
// charsCharFreq.get(c)) return false;
// }

// return true;
// }

// private Map<Character, Integer> getCharFreq(String s){
// Map<Character, Integer> map = new HashMap<>();
// for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
// return map;
// }
// }
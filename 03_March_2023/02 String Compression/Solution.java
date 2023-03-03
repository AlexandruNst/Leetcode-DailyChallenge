class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;

        char secondLastChar = chars[chars.length - 2];
        char lastChar = chars[chars.length - 1];
        int len = 0;
        int i = 0;
        int k = 0;
        while (i < chars.length - 1) {
            chars[k++] = chars[i];
            if (chars[i] != chars[i + 1]) {
                len++;
            } else {
                int consecutiveChars = 1;
                while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                    i++;
                    consecutiveChars++;
                }
                len++;
                if (consecutiveChars < 10) {
                    chars[k++] = (char) (consecutiveChars + '0');
                    len++;
                } else {
                    for (char cc : Integer.toString(consecutiveChars).toCharArray()) {
                        System.out.println(cc);
                        chars[k++] = cc;
                        len++;
                    }
                }
            }
            i++;
        }
        if (lastChar != secondLastChar) {
            len++;
            chars[k++] = chars[chars.length - 1];
        }

        return len;
    }
}
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zeroes = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zeroes++;
            else
                ones++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ones - 1; i++)
            res.append('1');
        for (int i = 0; i < zeroes; i++)
            res.append('0');
        res.append('1');
        return res.toString();
    }
}
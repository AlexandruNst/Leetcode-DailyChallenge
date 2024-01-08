class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArr = haystack.toCharArray();
        char[] needleCharArr = needle.toCharArray();

        if (needleCharArr.length > haystackCharArr.length) {
            return -1;
        }

        int pos = -1;
        int haystackIndex = 0;
        int needleIndex = 0;

        while (haystackIndex < haystackCharArr.length - needleCharArr.length + 1) {
            if (haystackCharArr[haystackIndex] == needleCharArr[needleIndex]) {
                pos = haystackIndex;
                while (needleIndex < needleCharArr.length) {
                    if (haystackCharArr[haystackIndex + needleIndex] != needleCharArr[needleIndex]) {
                        pos = -1;
                        needleIndex = 0;
                        break;
                    }
                    needleIndex++;
                }
                if (needleIndex == needleCharArr.length)
                    return pos;
            }
            haystackIndex++;
        }

        return pos;
    }
}
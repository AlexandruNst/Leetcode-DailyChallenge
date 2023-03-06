class Solution {
    public int findKthPositive(int[] arr, int k) {
        int jthMissingInteger = 0;
        int arrIndex = 0;
        int intIndex = 1;

        while (intIndex <= 1000 && arrIndex < arr.length) {
            if (arr[arrIndex] == intIndex) {
                arrIndex++;
                intIndex++;
            } else {
                jthMissingInteger++;
                if (jthMissingInteger == k) {
                    return intIndex;
                } else {
                    intIndex++;
                }
            }
        }

        while (jthMissingInteger < k - 1) {
            jthMissingInteger++;
            intIndex++;
        }

        return intIndex;
    }
}
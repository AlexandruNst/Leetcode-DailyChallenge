class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] s = new int[2];
        for (int i : students)
            s[i]++;
        for (int i : sandwiches)
            if (s[i]-- == 0)
                return s[1 - i];
        return 0;
    }
}
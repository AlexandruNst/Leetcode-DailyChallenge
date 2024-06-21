class Solution21 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sat = 0;
        int n = grumpy.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                sat += customers[i];
        }

        for (int i = 0; i < minutes; i++) {
            if (i < n && grumpy[i] == 1)
                sat += customers[i];
        }

        int l = 0;
        int r = minutes - 1;
        int newSat = sat;
        while (r < n - 1) {
            if (grumpy[l] == 1)
                newSat -= customers[l];
            l++;
            r++;
            if (grumpy[r] == 1)
                newSat += customers[r];

            sat = Math.max(sat, newSat);
        }

        return sat;
    }
}
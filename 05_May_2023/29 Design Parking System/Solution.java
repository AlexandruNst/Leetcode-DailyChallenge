class Solution {
    int[] spaces;

    public Solution(int big, int medium, int small) {
        spaces = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        return spaces[carType - 1]-- > 0;
    }
}

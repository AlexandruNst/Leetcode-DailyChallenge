import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> resArr = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int leftCornerX = i;
                    int leftCornerY = j;
                    int rightCornerX = i;
                    ;
                    int rightCornerY = j;
                    while (rightCornerX < land.length - 1 && land[rightCornerX + 1][j] == 1)
                        rightCornerX++;
                    while (rightCornerY < land[0].length - 1 && land[i][rightCornerY + 1] == 1)
                        rightCornerY++;
                    List<Integer> corners = Arrays.asList(leftCornerX, leftCornerY, rightCornerX, rightCornerY);
                    resArr.add(corners);

                    for (int k = leftCornerX; k <= rightCornerX; k++) {
                        for (int l = leftCornerY; l <= rightCornerY; l++) {
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }

        int[][] res = new int[resArr.size()][4];
        for (int i = 0; i < resArr.size(); i++) {
            List<Integer> cornersArr = resArr.get(i);
            int[] corners = new int[4];
            for (int j = 0; j < cornersArr.size(); j++) {
                corners[j] = cornersArr.get(j);
            }
            res[i] = corners;
        }

        return res;
    }
}
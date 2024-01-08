import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int numIndex = num.length - 1;
        int carryOver = 0;
        List<Integer> answer = new ArrayList<>();

        while (numIndex >= 0 || k > 0) {
            int sum = 0;

            if (numIndex >= 0)
                sum += num[numIndex];
            if (k > 0)
                sum += k % 10;
            sum += carryOver;

            int digit = sum % 10;
            carryOver = sum / 10;
            answer.add(digit);

            numIndex--;
            k /= 10;
        }

        if (carryOver == 1)
            answer.add(1);
        Collections.reverse(answer);
        return answer;
    }
}
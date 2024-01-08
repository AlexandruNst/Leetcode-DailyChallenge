import java.util.HashMap;
import java.util.Map;

// T: O(N)
// S: O(1)
class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int end = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int maxPicked = 0;
        int maxCurrent = 0;

        // empty basket
        if (fruits.length == 0)
            return 0;

        // Sliding window. While we only have 2 fruits in the window, increase window.
        // When increased and we now have 3 fruits, rerduce window by increasing left,
        // take update max if necessary
        while (end < fruits.length) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
            maxCurrent++;
            end++;
            if (basket.size() > 2) {
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if (basket.get(fruits[start]) == 0)
                    basket.remove(fruits[start]);
                start++;
                maxCurrent--;
                maxPicked = Math.max(maxCurrent, maxPicked);
            }
        }

        return Math.max(maxCurrent, maxPicked); // account for the last fruit
    }
}
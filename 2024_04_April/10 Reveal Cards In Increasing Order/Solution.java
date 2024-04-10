import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            int card = deck[i];
            if (!q.isEmpty()) {
                q.add(q.remove());
            }
            q.add(card);
        }
        int[] res = new int[deck.length];
        int i = deck.length - 1;
        while (!q.isEmpty()) {
            res[i--] = q.remove();
        }

        return res;
    }
}
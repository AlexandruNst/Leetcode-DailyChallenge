import java.util.PriorityQueue;

class Solution {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int k;

    public Solution(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        maxHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums)
            minHeap.add(num);
        while (minHeap.size() > k)
            maxHeap.add(minHeap.remove());
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
            return minHeap.peek();
        }
        if (val > minHeap.peek()) {
            maxHeap.add(minHeap.remove());
            minHeap.add(val);
        } else {
            maxHeap.add(val);
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
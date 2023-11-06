import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> pq;
    int seat;
    int n;

    public SeatManager(int n) {
        pq = new PriorityQueue<>(n);
        // for(int i = 1; i <= n; i++) pq.add(i);
        seat = 1;
        this.n = n;
    }

    public int reserve() {
        // return pq.poll();
        if (pq.size() > 0)
            return pq.poll();
        else
            return seat++;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
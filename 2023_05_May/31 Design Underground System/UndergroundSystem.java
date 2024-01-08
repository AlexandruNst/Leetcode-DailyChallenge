import java.util.*;

class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> checkedIn;
    Map<String, Pair<Double, Double>> trips;

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkedIn.get(id);
        String startStation = checkIn.getKey();
        int startTime = checkIn.getValue();
        String endStation = stationName;
        int endTime = t;
        String tripId = startStation + " " + endStation;
        Pair<Double, Double> tripSoFar = trips.getOrDefault(tripId, new Pair<>(0.0, 0.0));
        double newSum = tripSoFar.getKey() + (endTime - startTime);
        double newCount = tripSoFar.getValue() + 1;
        Pair<Double, Double> newTrip = new Pair<>(newSum, newCount);
        trips.put(tripId, newTrip);
        checkedIn.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String tripId = startStation + " " + endStation;
        double totalTime = trips.get(tripId).getKey();
        double count = trips.get(tripId).getValue();
        return totalTime / count;
    }

    public class Pair<T1, T2> {
        T1 val;
        T2 freq;

        Pair(T1 val, T2 freq) {
            this.val = val;
            this.freq = freq;
        }

        T1 getKey() {
            return this.val;
        }

        T2 getValue() {
            return this.freq;
        }
    }
}
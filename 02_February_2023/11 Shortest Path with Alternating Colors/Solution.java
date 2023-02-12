import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, ArrayList<Integer>> redMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> blueMap = new HashMap<>();

        for (int[] pair : redEdges) {
            int x = pair[0];
            int y = pair[1];

            ArrayList<Integer> nodes = redMap.getOrDefault(x, new ArrayList<>());
            nodes.add(y);
            redMap.put(x, nodes);
        }

        for (int[] pair : blueEdges) {
            int x = pair[0];
            int y = pair[1];

            ArrayList<Integer> nodes = blueMap.getOrDefault(x, new ArrayList<>());
            nodes.add(y);
            blueMap.put(x, nodes);
        }

        int[] answer = new int[n];
        answer[0] = 0;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = -1;
        }

        // Red-first runthrough
        Set<Integer> visitedRed = new HashSet<>();
        Set<Integer> visitedBlue = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visitedBlue.add(0);
        int steps = 0;
        boolean red = true;
        Map<Integer, ArrayList<Integer>> currMap;
        Set<Integer> currVisited;
        int qSize = q.size();
        while (!q.isEmpty()) {
            if (qSize == 0) {
                steps++;
                qSize = q.size();
                red = !red;

            }

            int currNode = q.remove();
            if (red) {
                currMap = redMap;
                currVisited = visitedBlue;
            } else {
                currMap = blueMap;
                currVisited = visitedRed;
            }

            if (currMap.containsKey(currNode)) {
                for (int nextNode : currMap.get(currNode)) {
                    if (!currVisited.contains(nextNode)) {
                        q.add(nextNode);
                        currVisited.add(nextNode);
                        if (answer[nextNode] == -1) {
                            answer[nextNode] = steps + 1;
                        } else {
                            answer[nextNode] = Math.min(answer[nextNode], steps + 1);
                        }
                    }
                }
            }
            qSize--;
        }

        // Blue-first runthrough
        visitedRed.clear();
        visitedBlue.clear();
        q.clear();
        q.add(0);
        visitedRed.add(0);
        steps = 0;
        red = false;
        qSize = q.size();
        while (!q.isEmpty()) {
            if (qSize == 0) {
                steps++;
                qSize = q.size();
                red = !red;
            }

            int currNode = q.remove();
            if (red) {
                currMap = redMap;
                currVisited = visitedBlue;
            } else {
                currMap = blueMap;
                currVisited = visitedRed;
            }

            if (currMap.containsKey(currNode)) {
                for (int nextNode : currMap.get(currNode)) {
                    if (!currVisited.contains(nextNode)) {
                        q.add(nextNode);
                        currVisited.add(nextNode);
                        if (answer[nextNode] == -1) {
                            answer[nextNode] = steps + 1;
                        } else {
                            answer[nextNode] = Math.min(answer[nextNode], steps + 1);
                        }
                    }
                }
            }
            qSize--;
        }

        return answer;
    }
}
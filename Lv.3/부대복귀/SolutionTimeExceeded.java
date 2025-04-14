import java.util.*;
class Solution {
    private static int bfs(List<List<Integer>> graph, int n, int start, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now == destination) {
                return distance[destination];
            }
            
            for (int next : graph.get(now)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                    distance[next] = distance[now] + 1;
                }
            }
        }
        
        return -1;
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(graph, n, sources[i], destination);
        }
        
        return answer;
    }
}
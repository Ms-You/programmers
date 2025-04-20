import java.util.*;
import java.util.stream.*;
class Solution {
    private static int[] bfs(int n, List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph.get(now)) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        return distance;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        int[] distance = bfs(n, graph, 1);
        int max = Arrays.stream(distance).max().getAsInt();
        
        for (int i = 0; i < distance.length; i++) {
            if (max == distance[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}

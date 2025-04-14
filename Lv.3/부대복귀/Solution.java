import java.util.*;
class Solution {
    private static int[] bfs(List<List<Integer>> graph, int n, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph.get(now)) {
                if (distance[next] == -1) {
                    queue.add(next);
                    distance[next] = distance[now] + 1;
                }
            }
        }
        
        return distance;
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
        
        int[] distance = bfs(graph, n, destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}
/*
각 출발지에서 목적지까지 sources.lenght 번의 bfs를 탐색하지 말고
목적지에서 시작해서 각 정점까지 한 번의 bfs를 통해 최단 거리를 구하기
*/
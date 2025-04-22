import java.util.*;
class Solution {
    private static void bfs(List<List<Integer>> graph, int[][] weight, int start, int[] minWeight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[minWeight.length];
        visited[start] = true;
        minWeight[start] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph.get(now)) {
                if (!visited[next] || minWeight[next] > minWeight[now] + weight[now][next]) {
                    minWeight[next] = minWeight[now] + weight[now][next];
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        int[][] weight = new int[n+1][n+1]; // 정점간의 가중치
        int[] minWeightA = new int[n+1];    // 정점 a에서 각 정점으로의 최소 가중치
        int[] minWeightB = new int[n+1];    // 정점 b에서 각 정점으로의 최소 가중치
        int[] minWeightS = new int[n+1];    // 정점 s에서 각 정점으로의 최소 가중치
        
        // 최솟값 비교를 위함
        Arrays.fill(minWeightA, Integer.MAX_VALUE);
        Arrays.fill(minWeightB, Integer.MAX_VALUE);
        Arrays.fill(minWeightS, Integer.MAX_VALUE);
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            graph.get(fare[0]).add(fare[1]);
            graph.get(fare[1]).add(fare[0]);
            weight[fare[0]][fare[1]] = fare[2];
            weight[fare[1]][fare[0]] = fare[2];
        }
        
        // 정점a, b, s로부터 각 정점으로의 최소 가중치를 구하기 위해 탐색
        bfs(graph, weight, a, minWeightA);
        bfs(graph, weight, b, minWeightB);
        bfs(graph, weight, s, minWeightS);
        
        for (int i = 0; i < minWeightA.length; i++) {
            answer = Math.min(answer, minWeightA[i] + minWeightB[i] + minWeightS[i]);
        }
        
        return answer;
    }
}
/*
1. 정점 a와 b, start에서 각 정점으로 이동하는 최소 가중치를 구하기
3. 정점을 방문할 때마다 정점 a와 b의 최소 비용을 더해서 최솟값을 비교
*/
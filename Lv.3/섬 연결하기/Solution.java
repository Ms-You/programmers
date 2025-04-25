// 크루스칼 알고리즘 (최소 신장 트리)
import java.util.*;
class Solution {
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        
        return parent[x];   // x의 루트값을 반환
    }
    
    private static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {   // 서로 다른 집합이라면 합침
            if (rank[rootX] > rank[rootY]) {    // 더 작은 집합을 더 큰 집합에 연결
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        int[] rank = new int[n];
        int edgeCnt = 0;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for (int[] cost : costs) {
            if (find(parent, cost[0]) != find(parent, cost[1])) {   // 같은 집합이 아니라면
                union(parent, rank, cost[0], cost[1]);
                answer += cost[2];
                edgeCnt++;
                
                if (edgeCnt == n-1) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
class Solution {
    /* 풀이 참조 */
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});

        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        moveTime[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowTime = now[2];

            if (nowTime >= dp[nowX][nowY]) {
                continue;
            }

            if (nowX == n-1 && nowY == m-1) {
                return nowTime;
            }

            dp[nowX][nowY] = nowTime;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (dp[nextX][nextY] == Integer.MAX_VALUE) {
                    int nextTime = Math.max(nowTime, moveTime[nextX][nextY]) + 1;
                    pq.add(new int[]{nextX, nextY, nextTime});
                }
            }
        }

        return -1;
    }
}
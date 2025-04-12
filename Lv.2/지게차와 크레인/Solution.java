class Solution {
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    
    private static void liftByCrane(char[][] store, char request) {
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                if (store[i][j] == request) {
                    store[i][j] = '#';
                }
            }
        }
    }
    
    private static void liftByForkLift(char[][] store, char request) {
        int row = store.length;
        int col = store[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row-1 || j == col-1) && !visited[i][j]) {
                    explore(store, i, j, request, visited);
                }
            }
        }
        
    }
    
    private static void explore(char[][] store, int x, int y, char request, boolean[][] visited) {
        if (x < 0 || x >= store.length || y < 0 || y >= store[0].length || visited[x][y]) {
            return;
        }
        
        visited[x][y] = true;
        
        if (store[x][y] == request) {
            store[x][y] = '#';
            return;
        } else if (store[x][y] != '#') {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            explore(store, nextX, nextY, request, visited);
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        char[][] store = new char[storage.length][];
        
        for (int i = 0; i < storage.length; i++) {
            store[i] = storage[i].toCharArray();
        }
        
        for (String request : requests) {
            int len = request.length();
            
            if (len == 1) {
                liftByForkLift(store, request.charAt(0));
            } else {
                liftByCrane(store, request.charAt(0));
            }
        }
        
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                if (store[i][j] != '#') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
/*
알파벳이 두 번 반복되면
그냥 반복문 돌면서 해당 알파벳 자리를 #으로 변경

알파벳이 하나면 해당 알파벳이 있는지 한 번만 확인할 것

(i == 0 || j == 0 || i == len-1 || j == len()-1) && [i][j] == '#'일 경우에만 탐색
*/
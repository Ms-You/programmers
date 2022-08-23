class Solution {
    public int solution(int n) {
        int cnt = 0;
        if (n % 2 == 0){
            for (int i = 1; i <= n; i++){
                if (n % i == 0){
                    if (i % 2 != 0) cnt++;
                }
            }
        }
        else {
            for (int i = 1; i <= n; i++)
                if (n % i == 0) cnt++;
        }
        return cnt;
    }
}

// 간단하게 수정한 코드
class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                if (i % 2 != 0) cnt++;
            }
        }
        return cnt;
    }
}
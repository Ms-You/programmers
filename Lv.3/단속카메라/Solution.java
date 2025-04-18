import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int minPoint = -30001;
        
        Arrays.sort(routes, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > minPoint || routes[i][1] < minPoint) {
                minPoint = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
/*
처음 생각한 풀이.
1. routes 배열을 오름차순 정렬
2. 최솟값부터 routes 배열을 돌면서 최솟값을 포함하는 배열의 인덱스를 구하기 위해 이분탐색
3. 위 과정을 반복하면서 최소 설치 횟수를 구한다.
=> 비효율적

다음 생각한 풀이.
1. routes 배열을 routes[i][1]을 기준으로 오름차순 정렬
2. 최솟값을 -30001로 지정
3. routes 배열을 돌면서 포함되어 최솟값이 포함되어 있는지 체크
4. 포함되어 있지 않다면 카메라를 한 대 늘리고, 최솟값을 routes[i][1]로 변경
=> for문 한 번이면 가능
*/
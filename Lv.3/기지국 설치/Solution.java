import java.util.*;
class Solution {
    private static int needStations(int start, int end, int w) {
        int len = end - start + 1;
        
        if (len < 0) {
            return 0;
        }
        
        if (len % (w*2+1) == 0) {
            return len / (w*2+1);
        } else {
            return len / (w*2+1)+1;
        }
    }
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        Arrays.sort(stations);
        
        answer += needStations(1, stations[0]-w-1, w);
        
        for (int i = 1; i < stations.length; i++) {
            answer += needStations(stations[i-1]+w+1, stations[i]-w-1, w);
        }
        
        answer += needStations(stations[stations.length-1]+w+1, n, w);

        return answer;
    }
}
/**
설치된 기지국을 기준으로 기지국이 필요한 아파트를 나눔
처음과 끝에 기지국이 설치될 수 있으므로 따로 수행

station-w-1 부터 station+w+1까지 

w = 1 일 때, 3칸 가능
w = 2 일 때, 5칸 가능
w = 3 일 때, 7칸 가능

=> (w*2+1) 만큼 가능

if (길이 % (w*2+1) == 0) {
  return 길이/(w*2+1);
} else {
  return 길이/(w*2+1)+1;
}
**/

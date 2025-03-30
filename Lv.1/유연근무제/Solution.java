class Solution {
    private static int getTime(int time) {
        int hour = time / 100;
        int minute = time % 100 + 10;

        if (minute >= 60) {
            hour++;
            minute %= 60;
        }
            
        return hour*100 + minute;
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int ontime = getTime(schedules[i]);
            int attendCnt = 0;
            int day = startday;
            
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day == 6 || day == 7) {
                    day %= 7;
                } else {
                    if (ontime >= timelogs[i][j]) {
                        attendCnt++;
                    }
                }
                
                day++;
            }
            
            if (attendCnt == 5) {
                answer++;
            }
        }
        
        return answer;
    }
}
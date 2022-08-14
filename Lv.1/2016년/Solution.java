class Solution {
    public String solution(int a, int b) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;
        
        for (int i = 0; i < a-1; i++)
            sum += months[i];
        sum += b-1;
        
        return day[sum%7];
    }
}
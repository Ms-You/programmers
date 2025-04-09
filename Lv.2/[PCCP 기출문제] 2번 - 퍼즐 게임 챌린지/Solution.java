class Solution {
    private static boolean isPossible(int[] diffs, int[] times, long level, long limit) {
        long time = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                time += (diffs[i]-level) * (times[i-1]+times[i]) + times[i];
            }
        }
        
        return time > limit;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (isPossible(diffs, times, mid, limit)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) left;
    }
}
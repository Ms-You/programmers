class Solution {
    private static long sumOfPartialSequence(int[] sequence) {
        long maxSum = 0;
        long[] dp = new long[sequence.length];
        dp[0] = sequence[0];
        
        for (int i = 1; i < sequence.length; i++) {
            dp[i] = Math.max(dp[i-1] + sequence[i], sequence[i]);
        }
        
        for (int i = 0; i < dp.length; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
    
    public long solution(int[] sequence) {
        long answer = 0;
        
        // [-1, 1, -1,...]
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                sequence[i] *= -1;
            }
        }
        
        answer = sumOfPartialSequence(sequence);

        // [1, -1, 1,...]
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] *= -1;
        }
        
        answer = Math.max(answer, sumOfPartialSequence(sequence));
        
        return answer;
    }
}
/*
1. sequence에 [-1,1,-1,...] 펄스와 [1,-1,1,...] 펄스를 각각 곱하기
2. dp 사용해서 부분 수열의 합 구하기
*/
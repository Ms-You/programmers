class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx = 0;
       
       for (long i = left; i <= right; i++){
           int temp = (int)(i / n - i % n);
           temp = temp < 0 ? 0 : temp;
           answer[idx++] = (int)(i % n) + temp + 1;
       }
        
       return answer;
    }
}
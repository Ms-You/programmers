class Solution {
    public int solution(int storey) {
        int answer = 0;
        String s = storey + "";
        int[] arr = new int[s.length()+1];
        
        for (int i = 0; i < s.length(); i++)
            arr[i+1] = s.charAt(i) - '0';
        
        for (int i = arr.length-1; i >= 0; i--){
            if (arr[i] == 5 && i > 0 && arr[i-1] >= 5){
                answer += 5;
                arr[i-1]++;
            } else if (arr[i] > 5){
                answer += 10-arr[i];
                arr[i-1]++;
                if (i == 0) answer++;
            } else {
                answer += arr[i];
            }
        }
        
        return answer;
    }
}
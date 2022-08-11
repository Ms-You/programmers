class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++){
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            temp = "0".repeat(n - temp.length()) + temp;
            temp = temp.replace("1", "#");
            temp = temp.replace("0", " ");
            answer[i] = temp;
        }
        
        return answer;
    }
}
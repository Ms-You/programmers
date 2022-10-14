class Solution {
    static int answer = 0;
    static int[] numbers;
    public int solution(int[] number) {
        numbers = number;
        comb(0, 0, new int[3]);
        
        return answer;
    }
    
    public static void comb(int cnt, int start, int[] selected){
        if (cnt == 3){
            int sum = 0;
            for (int i = 0; i < 3; i++)
                sum += selected[i];
            if (sum == 0) answer++;
            return;
        }
        
        for (int i = start; i < numbers.length; i++){
            selected[cnt] = numbers[i];
            comb(cnt+1, i+1, selected);
        }
    }
}
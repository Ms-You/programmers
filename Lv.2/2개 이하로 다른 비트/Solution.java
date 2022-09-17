class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++){
            String num = "0" + Long.toBinaryString(numbers[i]);
            int idx = num.lastIndexOf("0");
            if (idx == num.length()-1)
                sb.append(num.substring(0, idx) + '1');
            else
                sb.append(num.substring(0, idx) + "10" + num.substring(idx+2, num.length()));
            
            answer[i] = Long.parseLong(sb.toString(), 2);
            sb.setLength(0);
        }
        
        return answer;
    }
}
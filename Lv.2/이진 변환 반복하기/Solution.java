class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int zeroCnt = 0;
        int cnt = 0;
        
        while(sb.length() != 1){
            String temp = sb.toString().replaceAll("[0]", "");
            zeroCnt += sb.length() - temp.length();
            cnt++;
            sb.setLength(0);
            sb.append(Integer.toBinaryString(temp.length()));
        }
        
        return new int[]{cnt, zeroCnt};
    }
}
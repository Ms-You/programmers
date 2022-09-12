class Solution {
    public int solution(String name) {
        int cnt = 0, endA = 0;
        int moveCnt = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++){
            cnt += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            endA = i + 1;
            while(endA < name.length() && name.charAt(endA) == 'A') endA++;
            
            moveCnt = Math.min(moveCnt, i*2 + name.length() - endA);
            moveCnt = Math.min(moveCnt, (name.length() - endA)*2 + i);
        }
        
        return cnt + moveCnt;
    }
}
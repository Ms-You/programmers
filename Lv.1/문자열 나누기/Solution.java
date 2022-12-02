class Solution {
    public int solution(String s) {
        int total = 0;
        boolean flag = true;
        while(flag){
            char ch = s.charAt(0);
            int cnt = 0;
            int cnt2 = 0;
            flag = false;
            for (int i = 0; i < s.length(); i++){
                if (cnt != 0 && cnt == cnt2){
                    total++;
                    s = s.substring(i, s.length());
                    flag = true;
                    break;
                }
                
                if (ch == s.charAt(i)) cnt++;
                else cnt2++;
            }
        }
        
        return total+1;
    }
}
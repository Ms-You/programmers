class Solution {
    boolean solution(String s) {
        int cnt = 0;
        String[] str = s.split("");

        for (String ss : str) {
            ss = ss.toUpperCase();
            if (ss.equals("P"))
                cnt++;
            else if (ss.equals("Y"))
                cnt--;
        }
        
        return cnt == 0 ? true : false;
    }
}
class Solution {
    boolean solution(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') result++;
            else result--;
            if (result < 0) break;
        }
        
        return result == 0 ? true : false;
    }
}
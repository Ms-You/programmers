class Solution {
    public String solution(String p) {
        if (p.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        int lCnt = 0, rCnt = 0;
        boolean flag = true;
        
        for (String s : p.split("")){
            if (s.equals("(")) lCnt++;
            else rCnt++;
            
            if (rCnt > lCnt) flag = false;
            sb.append(s);
            if (lCnt == rCnt) break;
        }
        
        String u = sb.toString();
        String v = p.substring(u.length(), p.length());
        
        if (flag)  // 올바른 괄호 문자열일 때
            return u + solution(v);
        else {  // 균형잡힌 괄호 문자열일 때
            sb.setLength(0);
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            
            for (int i = 1; i < u.length()-1; i++){
                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
            
            return sb.toString();
        }
    }
}
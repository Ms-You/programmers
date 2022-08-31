class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = " " + s;
        s = s.toLowerCase();

        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++){
            if (ch[i-1] == ' ' && ch[i] != ' ' && ((int)ch[i] < 48 || (int)ch[i] > 57))
                sb.append(Character.toUpperCase(ch[i]));
            else
                sb.append(ch[i]);
        }
        
        return sb.toString();
    }
}
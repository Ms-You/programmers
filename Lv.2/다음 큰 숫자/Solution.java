class Solution {
    public int solution(int n) {
        int cnt = cnt(Integer.toBinaryString(n++), '1');

        while(cnt(Integer.toBinaryString(n), '1') != cnt) n++;

        return n;
    }

    public static int cnt(String s, char ch){
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ch) cnt++;
        return cnt;
    }
}
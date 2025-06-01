class Solution {
    private static String rle(int n, String s, int rleCnt) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(s.charAt(i));
                cnt = 1;
            }
        }

        sb.append(cnt);
        sb.append(s.charAt(s.length()-1));

        if (rleCnt+1 <= n) {
            return rle(n, sb.toString(), rleCnt+1);
        }

        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return rle(n, "1", 2);
    }
}
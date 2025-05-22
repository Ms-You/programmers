class Solution {
    private static int getLenOfPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = getLenOfPalindrome(s, i, i);
            int evenLen = getLenOfPalindrome(s, i, i+1);
            int len = Math.max(oddLen, evenLen);

            if (len > end-start+1) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }
}
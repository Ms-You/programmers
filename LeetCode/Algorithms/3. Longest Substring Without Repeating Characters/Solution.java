import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);

            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch)+1);
            }

            map.put(ch, r);
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }
}

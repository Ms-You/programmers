class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000007;
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        for (int i = 0; i < t; i++) {
            int zFreq = freq[25];

            for (int j = 25; j > 0; j--) {
                freq[j] = freq[j-1];
            }

            freq[0] = 0;    // z -> ab
            freq[0] = (freq[0] + zFreq) % MOD;
            freq[1] = (freq[1] + zFreq) % MOD;
        }

        int len = 0;
        for (int i = 0; i < freq.length; i++) {
            len = (len + freq[i]) % MOD;
        }

        return len;
    }
}
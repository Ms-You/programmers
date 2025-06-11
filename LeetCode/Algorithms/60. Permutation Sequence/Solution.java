class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int[] factorials = new int[n];
        factorials[0] = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i-1] * i;
        }

        // 인덱스 0부터 시작
        k -= 1;

        for (int i = n; i > 0; i--) {
            int fact = factorials[i-1];
            int idx = k / fact;

            sb.append(list.remove(idx));

            k %= fact;
        }
        
        return sb.toString();
    }
}
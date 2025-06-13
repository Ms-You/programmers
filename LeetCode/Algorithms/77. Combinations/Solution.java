class Solution {
    private static void comb(List<List<Integer>> answer, int[] arr, int start, int cnt, int[] selected, int k) {
        if (cnt == k) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < cnt; i++) {
                list.add(selected[i]);
            }

            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            selected[cnt] = arr[i];
            comb(answer, arr, i+1, cnt+1, selected, k);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        comb(answer, arr, 0, 0, new int[k], k);

        return answer;
    }
}
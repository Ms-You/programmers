class Solution {
    private static void comb(List<List<Integer>> answer, int[] nums, int start, int cnt, int[] selected, int k) {
        if (cnt == k) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < cnt; i++) {
                list.add(selected[i]);
            }

            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            selected[cnt] = nums[i];
            comb(answer, nums, i+1, cnt+1, selected, k);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            comb(answer, nums, 0, 0, new int[i], i);
        }

        return answer;
    }
}
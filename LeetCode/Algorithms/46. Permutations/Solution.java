class Solution {
    private static void perm(int[] nums, List<List<Integer>> answer, int cnt, int[] selected, boolean[] visited) {
        if (cnt == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                temp.add(selected[i]);
            }

            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = nums[i];
                perm(nums, answer, cnt+1, selected, visited);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        perm(nums, answer, 0, new int[nums.length], new boolean[nums.length]);

        return answer;
    }
}
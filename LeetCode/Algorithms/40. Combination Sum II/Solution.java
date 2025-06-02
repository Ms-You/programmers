class Solution {
    private static void dfs(int[] candidates, int target, int depth, List<List<Integer>> answer, List<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = depth; i < candidates.length; i++) {
                if (i > depth && candidates[i] == candidates[i-1]) {
                    continue;
                }

                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], i+1, answer, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 풀이 참조
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, answer, new ArrayList<>());

        return answer;
    }
}
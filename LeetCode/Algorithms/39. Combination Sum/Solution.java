class Solution {
    private static void dfs(int[] candidates, int target, int sum, int depth, List<List<Integer>> answer, List<Integer> temp) {
        if (target == sum) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        if (depth >= candidates.length || sum > target) {
            return;
        }

        temp.add(candidates[depth]);
        dfs(candidates, target, sum+candidates[depth], depth, answer, temp);
        temp.remove(temp.size()-1);
        dfs(candidates, target, sum, depth+1, answer, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(candidates, target, 0, 0, answer, new ArrayList<>());

        return answer;
    }
}
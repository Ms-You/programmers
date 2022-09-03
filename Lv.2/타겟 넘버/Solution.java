class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs_recursion(numbers, 0, target, 0);
        
        return answer;
    }
    
    public static void dfs_recursion(int[] numbers, int depth, int target, int sum){
        if (numbers.length == depth){
            if (target == sum) answer++;
        } else{
            dfs_recursion(numbers, depth+1, target, sum+numbers[depth]);
            dfs_recursion(numbers, depth+1, target, sum-numbers[depth]);
        }
    }
}
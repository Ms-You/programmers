class Solution {
    public int firstMissingPositive(int[] nums) {
        int answer = 1;
        Arrays.sort(nums);

        for (int num : nums) {
            if (answer == num) {
                answer++;
            } else if (num > answer) {
                break;
            }
        }

        return answer;
    }
}
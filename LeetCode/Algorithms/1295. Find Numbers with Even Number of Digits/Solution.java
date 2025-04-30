class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int len = Integer.toString(num).length();

            if (len % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }
}
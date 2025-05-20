// 풀이 참조
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length+1];

        for (int i = 0; i < queries.length; i++) {
            arr[queries[i][0]]--;
            arr[queries[i][1]+1]++;
        }

        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += arr[i];
            if (Math.max(0, nums[i]+diff) != 0) {
                return false;
            }
        }

        return true;
    }
}
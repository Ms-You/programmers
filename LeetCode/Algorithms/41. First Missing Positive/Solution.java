class Solution {
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int firstMissingPositive(int[] nums) {
        int answer = 1;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

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
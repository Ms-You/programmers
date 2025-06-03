class Solution {
    public int firstMissingPositive(int[] nums) {
        int answer = 1;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int[] temp = new int[max-min+1];

        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]-min]++;
        }

        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                nums[idx++] = i+min;
                temp[i]--;
            }
        }

        for (int num : nums) {
            if (num == answer) {
                answer++;
            } else if (num > answer) {
                break;
            }
        }

        return answer;
    }
}
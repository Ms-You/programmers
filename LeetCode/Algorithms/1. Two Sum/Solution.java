import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                answer = new int[]{map.get(complement), i};
                break;
            }

            map.put(nums[i], i);
        }
        
        return answer;
    }
}
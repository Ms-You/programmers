class Solution {
    // countingsort
    public void sortColors(int[] nums) {
        int[] temp = new int[301];
        int idx = 0;

        for (int num : nums) {
            temp[num]++;
        }

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                nums[idx++] = i;
                temp[i]--;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
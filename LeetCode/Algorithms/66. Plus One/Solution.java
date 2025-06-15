class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] answer = new int[digits.length+1];
        answer[0] = 1;
        
        for (int i = 0; i < digits.length; i++) {
            answer[i+1] = digits[i];
        }

        return answer;
    }
}
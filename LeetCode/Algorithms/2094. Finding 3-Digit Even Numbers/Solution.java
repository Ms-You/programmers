import java.util.*;
class Solution {
    private static boolean isValid(int[] freq1, int[] freq2) {
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] < freq2[i]) {
                return false;
            }
        }

        return true;
    }
    
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> answer = new ArrayList<>();
        int[] freq1 = new int[10];

        for (int digit : digits) {
            freq1[digit]++;
        }

        for (int i = 100; i < 1000; i+=2) {
            int num = i;
            int[] freq2 = new int[10];

            while (num > 0) {
                int remains = num % 10;
                freq2[remains]++;
                num /= 10;
            }

            if (isValid(freq1, freq2)) {
                answer.add(i);
            }
        }

        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
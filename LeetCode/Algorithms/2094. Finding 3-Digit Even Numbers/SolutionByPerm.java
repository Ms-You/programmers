import java.util.*;
class Solution {
    static Set<String> numSet = new HashSet<>();
    static int M = 3;
    private static void perm(int cnt, int[] selected, boolean[] visited, int[] digits) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(selected[i]);
            }

            numSet.add(sb.toString());
            
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = digits[i];
                perm(cnt+1, selected, visited, digits);
                visited[i] = false;
            }
        }
    }

    private static boolean isEvenNum(int num) {
        if (num % 2 == 0 && Integer.toString(num).length() == 3) {
            return true;
        }

        return false;
    }

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> numList = new ArrayList<>();
        boolean isValid = false;

        for (int digit : digits) {
            if (digit % 2 == 0) {
                isValid = true;
            }
        }

        if (!isValid) {
            return new int[0];
        }

        perm(0, new int[M], new boolean[digits.length], digits);

        Iterator<String> it = numSet.iterator();
        while (it.hasNext()) {
            int num = Integer.parseInt(it.next());

            if (isEvenNum(num)) {
                numList.add(num);
            }
        }
        
        Collections.sort(numList);
        numSet.clear();

        return numList.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
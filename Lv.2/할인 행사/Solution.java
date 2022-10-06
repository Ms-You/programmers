import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum = Arrays.stream(number).sum();
        int start = 0;

        while(true){
            boolean flag = true;
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>(Arrays.asList(want));
            if (sum > discount.length) break;
            for (int i = start; i < sum; i++){
                if (!list.contains(discount[i])) {
                    sb.setLength(0);
                    flag = false;
                    break;
                } else {
                    sb.append(discount[i] + " ");
                }
            }

            String[] s = sb.toString().split(" ");
            for (int i = 0; i < want.length; i++){
                int freq = Collections.frequency(Arrays.asList(s), want[i]);
                if (freq != number[i]){
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
            start++;
            sum++;
        }

        return answer;
    }
}
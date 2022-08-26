import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0, max = people.length, answer = 0;
        
        while (min < max) {
            if (people[min] + people[max-1] <= limit){
                min++;
                max--;
                answer++;
            } else {
                max--;
                answer++;
            }
        }
        
        return answer;
    }
}
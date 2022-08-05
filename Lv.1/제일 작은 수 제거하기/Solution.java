import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> array = IntStream
            .of(arr)
            .boxed()
            .collect(Collectors.toList());
        array.remove(array.indexOf(min));
        
        return array.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
    }
}
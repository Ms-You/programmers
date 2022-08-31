import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < clothes.length; i++)
            list.add(clothes[i][1]);

        List<Integer> list2 = new ArrayList<>();

        Set<String> set = new HashSet<>(list);
        for (String str : set)
            list2.add(Collections.frequency(list, str));

        int answer = 1;
        for (int n : list2)
            answer *= n+1;


        return answer-1;
    }
}
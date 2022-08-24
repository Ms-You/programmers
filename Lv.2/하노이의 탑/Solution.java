import java.util.*;
class Solution {
    public int[][] solution(int n) {
        List<Integer> list = new ArrayList<>();
        list = hanoi(list, n, 1, 2, 3);

        int[][] answer = new int[list.size()/2][2];
        for (int i = 0; i < list.size(); i++){
            if (i % 2 == 0)
                answer[i/2][0] = list.get(i);
            else
                answer[i/2][1] = list.get(i);
        }

        return answer;
    }
    

    public static List<Integer> hanoi(List<Integer> list, int n, int from, int tmp, int to){
        if (n == 1){
            list.add(from);
            list.add(to);
        }
        else {
            hanoi(list, n-1, from, to, tmp);
            list.add(from);
            list.add(to);
            hanoi(list, n-1, tmp, from, to);
        }
        return list;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] result = new int[3];
        
        for (int i = 0; i < answers.length; i++){
            if (stu1[i % stu1.length] == answers[i])
                result[0] += 1;
            if (stu2[i % stu2.length] == answers[i])
                result[1] += 1;
            if (stu3[i % stu3.length] == answers[i])
                result[2] += 1;
        }
        
        int max = Math.max(Math.max(result[0], result[1]), result[2]);
        List<Integer> list = new ArrayList<>();
        
        if (max == result[0])
            list.add(1);
        if (max == result[1])
            list.add(2);
        if (max == result[2])
            list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}
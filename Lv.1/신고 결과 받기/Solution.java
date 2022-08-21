import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(report));
        String[] reportList = set.toArray(new String[0]);
        List<String> userList = new ArrayList<>(Arrays.asList(id_list));
        int[] answer = new int[id_list.length];
        int[] reported = new int[userList.size()];

        List<String> who1 = new ArrayList<>();
        List<String> who2 = new ArrayList<>();

        for (int i = 0; i < reportList.length; i++){
            who1.add(reportList[i].split(" ")[0]);
            who2.add(reportList[i].split(" ")[1]);
        }
        
        for (int i = 0; i < who2.size(); i++)
            reported[userList.indexOf(who2.get(i))] += 1;       
        
        for (int i = 0; i < reported.length; i++){
            if (reported[i] >= k){
                for (int j = 0; j < who2.size(); j++){
                    if (id_list[i].equals(who2.get(j)))
                        answer[userList.indexOf(who1.get(j))] += 1;
                }
            }
        }
        
        return answer;
    }
}
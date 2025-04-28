import java.util.*;
class Solution {
    private static boolean checkSame(String user_name, String banned_user_name) {
        if (user_name.length() != banned_user_name.length()) {
            return false;
        }
        
        for (int i = 0; i < user_name.length(); i++) {
            if (user_name.charAt(i) != banned_user_name.charAt(i) && banned_user_name.charAt(i) != '*') {
                return false;
            }
        }
        
        return true;
    }
    
    private static void dfs(List<Integer> userList, Set<Set<Integer>> userSet, boolean[] visited, String[] user_id, String[] banned_id) {
        if (userList.size() == banned_id.length) {
            Set<Integer> set = new HashSet<>(userList);
            userSet.add(set);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && checkSame(user_id[i], banned_id[userList.size()])) {
                visited[i] = true;
                userList.add(i);
                dfs(userList, userSet, visited, user_id, banned_id);
                visited[i] = false;
                userList.remove(userList.size()-1);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        List<Integer> userList = new ArrayList<>();
        Set<Set<Integer>> userSet = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];
        
        dfs(userList, userSet, visited, user_id, banned_id);
        
        return userSet.size();
    }
}
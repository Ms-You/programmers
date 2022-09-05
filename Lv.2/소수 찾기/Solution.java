import java.util.*;
class Solution {
    
    static Set<Integer> set = new HashSet<>();
    
    // 완전탐색 - 순열 (중복 x)
    public static void perm(int cnt, String[] selected, boolean[] visited, String[] str){
        if (cnt == selected.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++)
                sb.append(selected[i]);
            set.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            return;
        }
        
        for (int i = 0; i < str.length; i++){
            if (!visited[i]){
                visited[i] = true;
                selected[cnt] = str[i];
                perm(cnt+1, selected, visited, str);
                visited[i] = false;
            }
        }
    }
    
    // 소수 검증
    public static int isPrime(int n){
        if (n < 2) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return 0;
        return 1;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        String[] str = numbers.split("");
        
        for (int i = 0; i < str.length; i++)
            perm(0, new String[i+1], new boolean[str.length], str);
        
        List<Integer> list = new ArrayList<>(set);
        
        for (int i = 0; i < list.size(); i++)
            answer += isPrime(list.get(i));
        
        return answer;
    }
    
}
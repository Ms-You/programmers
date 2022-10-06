import java.util.*;
class Solution {
    static int[] arr;
    static List<Integer> belong = new ArrayList<>();
    static List<Integer> cnt = new ArrayList<>();
    
    public static void chain(int key){
        while (!belong.contains(arr[key-1])){
            key = arr[key-1];
            belong.add(key);
        }
        cnt.add(belong.size());
    }
    
    public int solution(int[] cards) {
        arr = cards;
        
        for (int i = 0; i < arr.length; i++){
            if (belong.size() == arr.length) break;
            chain(i+1);
        }
        
        if (cnt.size() == 1) return 0;
        for (int i = cnt.size()-1; i > 0; i--)
            cnt.set(i, cnt.get(i) - cnt.get(i-1));
        
        Collections.sort(cnt, Collections.reverseOrder());
        
        return cnt.get(0) * cnt.get(1);
    }
}
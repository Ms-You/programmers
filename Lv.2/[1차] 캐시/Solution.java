import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int sec = 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < cities.length; i++){
            String value = cities[i].toUpperCase();
            if (list.size() < cacheSize){
                if (list.contains(value)){
                    list.add(list.remove(list.indexOf(value)));
                    sec += 1;
                } else {
                    list.add(value);
                    sec += 5;
                }
            } else {
                if (list.contains(value)){
                    list.add(list.remove(list.indexOf(value)));
                    sec += 1;
                } else {
                    list.remove(0);
                    list.add(value);
                    sec += 5;
                }
            }
        }
        
        return sec;
    }
}
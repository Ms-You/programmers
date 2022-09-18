import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int sec = 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < cities.length; i++){
            String value = cities[i].toUpperCase();
            if (list.contains(value)){
                list.add(list.remove(list.indexOf(value)));
                sec += 1;
            } else {
                if (list.size() == cacheSize){
                    list.remove(0);
                    list.add(value);
                } else
                    list.add(value);
                sec += 5;
            }
        }
        
        return sec;
    }
}
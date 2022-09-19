import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase().replaceAll("[^A-Z]", "0");
        str2 = str2.toUpperCase().replaceAll("[^A-Z]", "0");
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        int intersection = 0;
        
        for (int i = 0; i < str1.length()-1; i++){
            if (str1.charAt(i) != '0' && str1.charAt(i+1) != '0'){
                list1.add(str1.substring(i, i+2));
                union.add(str1.substring(i, i+2));
            }
        }
        
        for (int i = 0; i < str2.length()-1; i++){
            if (str2.charAt(i) != '0' && str2.charAt(i+1) != '0'){
                list2.add(str2.substring(i, i+2));
                union.add(str2.substring(i, i+2));
            }
        }
        
        if (list1.size() == 0 && list2.size() == 0) return 65536;
        
        for (int i = 0; i < list2.size(); i++){
            if (list1.contains(list2.get(i))){
                intersection++;
                list1.remove(list1.indexOf(list2.get(i)));
                union.remove(union.indexOf(list2.get(i)));
            }
        }
        
        return (int)((double)intersection/union.size() * 65536);
    }
}
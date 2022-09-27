import java.util.*;
class Solution {
    public static int findOnlyNum(String s, String f){
        StringBuilder sb = new StringBuilder();
        
        s = s.replace(f, "");
        for (char ch : s.toCharArray()){
            if ((int) ch >= 48 && (int) ch <= 47 && sb.toString().length() < 5) sb.append(ch);
            else break;
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    public String[] solution(String[] files) {        
        Arrays.sort(files, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                String f1 = s1.split("[0-9]")[0];
                String f2 = s2.split("[0-9]")[0];
                
                int value = f1.toLowerCase().compareTo(f2.toLowerCase());
                if (value == 0)
                    value = findOnlyNum(s1, f1) - findOnlyNum(s2, f2);

                return value;
            }
        });
        
        return files;
    }
}
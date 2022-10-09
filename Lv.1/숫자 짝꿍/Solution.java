import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        List<Integer> list = new ArrayList<>();
		int[] x = new int[10];
		int[] y = new int[10];
		
		for (String s : X.split(""))
		    x[Integer.parseInt(s)]++;
		
		for (String s : Y.split(""))
		    y[Integer.parseInt(s)]++;
		
        for (int i = 0; i < 10; i++){
            while(x[i] > 0 && y[i] > 0){
                list.add(i);
                x[i]--;
                y[i]--;
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if (list.size() == 0) return "-1";
        else if (list.get(0) == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int n : list)
            sb.append(n);
        
        return sb.toString();
    }
}
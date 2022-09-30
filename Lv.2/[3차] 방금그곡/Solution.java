import java.util.*;
class Solution {
    public static String trim(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length()-2; i >= 0; i--){
            if (s.charAt(i+1) == '#'){
                sb.deleteCharAt(i+1);
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }
        return sb.toString();
    }
    
    public String solution(String m, String[] musicinfos) {
        List<String> song = new ArrayList<>();
	    List<Integer> time = new ArrayList<>();
	    
        for (String s : musicinfos){
            StringBuilder sb = new StringBuilder();
            String[] str = s.split(",");
            String[] startTime = str[0].split(":");
            String[] endTime = str[1].split(":");
            int minute = 0;
            if (Integer.parseInt(endTime[1]) >= Integer.parseInt(startTime[1]))
                minute = (Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0]))*60+Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]);
            else
                minute = (Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0])-1)*60+Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1])+60;
            
            String temp = trim(str[3]);
            for(int i = 0; i < minute/temp.length(); i++) sb.append(temp);
            sb.append(temp.substring(0, minute%temp.length()));
            
            m = trim(m);
            if (sb.toString().contains(m)){
                song.add(str[2]);
                time.add(minute);
            }
        }
        
        String name = "";
	    int max = 0;
	    if (song.size() == 0) return "(None)";
        else if (song.size() == 1) return song.get(0);
        else{
            for (int i = 0; i < time.size(); i++){
                if (max < time.get(i)){
                    name = song.get(i);
                    max = time.get(i);
                }
            }
            return name;
        }
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> map = new HashMap<>();
        List<String> in = new ArrayList<>();
        List<String> outNum = new ArrayList<>();
        List<String> outTime = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++){
            String[] s = records[i].split(" ");
            if (s[2].equals("IN"))
                in.add(s[1] + " " + s[0]);
            else if (s[2].equals("OUT")){
                outNum.add(s[1]);
                outTime.add(s[0]);
            }
        }
        
        for (int i = 0; i < in.size(); i++){
            int time = 0;
            String startTime = in.get(i).split(" ")[1];
            if (outNum.contains(in.get(i).split(" ")[0])){
                int idx = outNum.indexOf(in.get(i).split(" ")[0]);
                if (Integer.parseInt(startTime.substring(3,5)) > Integer.parseInt(outTime.get(idx).substring(3, 5))){
                    time += (Integer.parseInt(outTime.get(idx).substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2))-1)*60;
                    time += (60 - Integer.parseInt(startTime.substring(3, 5)) + Integer.parseInt(outTime.get(idx).substring(3, 5)));
                } else {
                    time += (Integer.parseInt(outTime.get(idx).substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2)))*60;
                    time += (Integer.parseInt(outTime.get(idx).substring(3, 5)) - Integer.parseInt(startTime.substring(3, 5)));
                }
                outNum.remove(idx);
                outTime.remove(idx);
            } else {
                time += (23 - Integer.parseInt(startTime.substring(0, 2)))*60;
                time += 59 - Integer.parseInt(startTime.substring(3, 5));
            }
            
            map.put(Integer.parseInt(in.get(i).split(" ")[0]), map.getOrDefault(Integer.parseInt(in.get(i).split(" ")[0]), 0) + time);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int idx = 0;
        int[] answer = new int[map.size()];
        
         for (int key : keySet) {
            int total = map.get(key);
            if (total <= fees[0]) total = fees[1];
            else total = fees[1] + (int)Math.ceil((float)(total-fees[0])/fees[2]) * fees[3];
            answer[idx++] = total;
        }
        
        return answer;
    }
}
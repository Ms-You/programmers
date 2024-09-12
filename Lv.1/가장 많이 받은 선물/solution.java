import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // (보낸 사람, (받은 사람, 보낸 사람에게 받은 선물 개수))
        Map<String, Map<String, Integer>> senderAndReceiverMap = new HashMap<>();
        // (이름, 선물 지수)
        Map<String, Integer> rateMap = new HashMap<>();
        // (이름, 다음 달에 받을 선물 개수)
        Map<String, Integer> nextMap = new HashMap<>();
        
        for (String f1 : friends) {
            senderAndReceiverMap.put(f1, new HashMap<>());
            
            for (String f2 : friends) {
                if (f1.equals(f2)) {    // 자기 자신이면 pass
                    continue;
                }
                
                senderAndReceiverMap.get(f1).put(f2, 0);
            }
            
            rateMap.put(f1, 0);
            nextMap.put(f1, 0);
        }
        
        for (String gift : gifts) {
            String[] str = gift.split(" ");
            String sender = str[0];
            String receiver = str[1];
            
            senderAndReceiverMap.get(sender).put(receiver, senderAndReceiverMap.get(sender).getOrDefault(receiver, 0) + 1);
            
            // 선물 지수 계산
            rateMap.put(sender, rateMap.getOrDefault(sender, 0) + 1);
            rateMap.put(receiver, rateMap.getOrDefault(receiver, 0) - 1);
        }
        
        for (String f1 : friends) {
            for (String f2 : friends) {
                if (f1.equals(f2)) {
                    continue;
                }
                
                int sendCnt = senderAndReceiverMap.get(f1).get(f2);
                int receiveCnt = senderAndReceiverMap.get(f2).get(f1);
                
                if (sendCnt == receiveCnt) {    // 같을 경우 선물 지수 계산
                    int sendRate = rateMap.get(f1);
                    int receiveRate = rateMap.get(f2);
                    
                    if (sendRate > receiveRate) {
                        nextMap.put(f1, nextMap.getOrDefault(f1, 0) + 1);
                    }
                } else if (sendCnt > receiveCnt) {
                    nextMap.put(f1, nextMap.getOrDefault(f1, 0) + 1);
                }
            }
        }
        
        List<String> keySet = new ArrayList<>(nextMap.keySet());
        
        for (String key : keySet) {
            answer = Math.max(answer, nextMap.get(key));
        }
        
        // Collections.max(nextMap.values());
        
        return answer;
    }
}
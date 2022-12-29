class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int tenNum = storey / 10;
            int lastNum = storey % 10;
            
            if (lastNum == 5 && tenNum % 10 >= 5){
                storey += 10;
                answer += 5;
            } else if (lastNum > 5){
                storey += 10;
                answer += 10-lastNum;
            } else {
                answer += lastNum;
            }
            storey /= 10;
        }
        
        return answer;
    }
}
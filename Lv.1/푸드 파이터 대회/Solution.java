class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");
        
        for (int i = 1; i < food.length; i++){
            if (food[i] % 2 == 1) food[i] -= 1;
            
            for (int j = 0; j < food[i]/2; j++){
                sb.insert(sb.toString().length()/2, i);
                sb.insert(sb.toString().length()/2+1, i);
            }
        }
        
        return sb.toString();
    }
}
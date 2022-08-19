class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10, right = 12;
        
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0)
                numbers[i] = 11;
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                left = numbers[i];
                sb.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right = numbers[i];
                sb.append("R");
            } else {
                int leftPart = Math.abs(numbers[i] - left)/3 + Math.abs(numbers[i] - left) % 3;
                int rightPart = Math.abs(numbers[i] - right)/3 + Math.abs(numbers[i] - right) % 3;
                
                if (leftPart > rightPart){
                    right = numbers[i];
                    sb.append("R");
                } else if (leftPart < rightPart){
                    left = numbers[i];
                    sb.append("L");
                } else {
                    if (hand.equals("left")){
                        left = numbers[i];
                        sb.append("L");
                    } else {
                        right = numbers[i];
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int width = 1; width <= sum/2; width++){
            int height = sum/width;
            if (sum % width == 0 && width >= height && width >= 3 && height >= 3 && (width-2)*(height-2) == yellow){
                answer[0] = width;
                answer[1] = height;
            }
        }
        
        return answer;
    }
}
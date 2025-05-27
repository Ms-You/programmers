class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int startIdx = 0, endIdx = height.length-1;

        while (startIdx < endIdx) {
            int startH = height[startIdx];
            int endH = height[endIdx];
            int minH = Math.min(startH, endH);
            int width = endIdx - startIdx;
            int area = minH * width;
            
            if (answer < area) {
                answer = area;
            } else if (startH < endH) {
                startIdx++;
            } else {
                endIdx--;
            }
        }

        return answer;
    }
}
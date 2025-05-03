class Solution {
    private static int minChangeCount(int value, int[] tops, int[] bottoms) {
        int count = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != value) {
                if (bottoms[i] == value) {
                    count++;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return count;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int answer = Integer.MAX_VALUE;
        
        answer = Math.min(answer, minChangeCount(tops[0], tops, bottoms));
        answer = Math.min(answer, minChangeCount(tops[0], bottoms, tops));
        answer = Math.min(answer, minChangeCount(bottoms[0], tops, bottoms));
        answer = Math.min(answer, minChangeCount(bottoms[0], bottoms, tops));
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
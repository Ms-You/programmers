class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;

        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                int diffIAndJ = Math.abs(arr[i] - arr[j]);

                if (diffIAndJ > a) {
                    continue;
                }

                for (int k = j+1; k < arr.length; k++) {    
                    int diffJAndK = Math.abs(arr[j] - arr[k]);
                    int diffIAndK = Math.abs(arr[i] - arr[k]);

                    if (diffJAndK <= b && diffIAndK <= c) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
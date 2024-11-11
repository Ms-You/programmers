class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        int maxBill = Math.max(bill[0], bill[1]);
        int minBill = Math.min(bill[0], bill[1]);
        
        while(maxBill > maxWallet || minBill > minWallet) {
            maxBill /= 2;
            answer++;
            
            if (maxBill < minBill) {
                int temp = minBill;
                minBill = maxBill;
                maxBill = temp;
            }
        }
        
        return answer;
    }
}
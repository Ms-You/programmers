class Solution {
    public static int isPrime(long n){
        if(n < 2) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return 0;
        return 1;
    }
    
    public int solution(int n, int k) {
        String[] str = Integer.toString(n, k).replaceAll("[0]{2,}", "0").split("0");
        int cnt = 0;
        
        for (int i = 0; i < str.length; i++)
            cnt += isPrime(Long.parseLong(str[i]));
        
        return cnt;
    }
}
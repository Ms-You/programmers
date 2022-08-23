class Solution {
    public int solution(int[] arr) {
        if (arr.length == 0)
            return arr[0];
        
        int gcd = gcd(arr[0], arr[1]);
        // 최소 공배수 = a x b / gcd
        int lcm = arr[0]*arr[1]/gcd;
        
        for (int i = 2; i < arr.length; i++){
            gcd = gcd(lcm, arr[i]);
            lcm = lcm*arr[i]/gcd;
        }
        
        return lcm;
    }
    
    // 최대 공약수
    public static int gcd(int a, int b){
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}
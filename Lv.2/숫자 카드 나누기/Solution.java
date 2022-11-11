class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcd_a = get_gcd(arrayA);
        int gcd_b = get_gcd(arrayB);
        
        boolean flag = true;
        if (gcd_b != 1){
            for (int a : arrayA){
                if (a % gcd_b == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) answer = gcd_b;
        }
        
        flag = true;
        if (gcd_a != 1){
            for (int b : arrayB){
                if (b % gcd_a == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) answer = Math.max(answer, gcd_a);
        }
        
        return answer;
    }
    
    public static int get_gcd(int[] array){
        int val = array[0];
        for (int i = 1; i < array.length; i++)
            val = gcd(val, array[i]);
        
        return val;
    }
    
    public static int gcd(int a, int b){
        if (a % b == 0) return b;
        
        return gcd(b, a % b);
    }
}
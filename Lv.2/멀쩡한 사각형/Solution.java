class Solution {
    public long solution(int w, int h) {
        int gcd = gcd(w, h);
        long ww = (long)w;
        long hh = (long)h;
        return (ww*hh) - (ww/gcd + hh/gcd - 1)*gcd;
    }
    
    public static int gcd(int a, int b){
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
}
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = A.length-1;
        int j = B.length-1;
        
        while(i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                i--;
                j--;
                answer++;
            } else {
                i--;
            }
        }
        
        return answer;
    }
}
/**
내림차순 정렬
A와 B의 크기 비교
B가 더 크면 A의 다음 값과 B의 다음 값을 비교
A가 더 크거나 같으면 B의 현재 값과 A의 다음 값과 비교
**/
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] move = new int[dirs.length()+1][2];
        move[0][0] = 0;
        move[0][1] = 0;
	    
        for(int i = 0; i < dirs.length(); i++){
            if (dirs.charAt(i) == 'L'){
                if (move[i][0] == -5){
                    move[i+1][0] = move[i][0];
                    move[i+1][1] = move[i][1];
                } else {
                    move[i+1][0] = move[i][0] - 1;
                    move[i+1][1] = move[i][1];
                }
            } else if (dirs.charAt(i) == 'R'){
                if (move[i][0] == 5){
                    move[i+1][0] = move[i][0];
                    move[i+1][1] = move[i][1];
                } else {
                    move[i+1][0] = move[i][0] + 1;
                    move[i+1][1] = move[i][1];
                }
            } else if (dirs.charAt(i) == 'U'){
                if (move[i][1] == 5){
                    move[i+1][1] = move[i][1];
                    move[i+1][0] = move[i][0];
                } else {
                    move[i+1][1] = move[i][1] + 1;
                    move[i+1][0] = move[i][0];
                }
            } else if (dirs.charAt(i) == 'D'){
                if (move[i][1] == -5){
                    move[i+1][1] = move[i][1];
                    move[i+1][0] = move[i][0];
                } else {
                    move[i+1][1] = move[i][1] - 1;
                    move[i+1][0] = move[i][0];
                }
            }

        }

        List<String> list = new ArrayList<>();

        for(int i = 1; i < move.length; i++){
	        String s = move[i-1][0] + ", " + move[i-1][1];
	        String ss = move[i][0] + ", " + move[i][1];
	        String temp = s + ss;
            String temp2 = ss + s;
	        if (list.contains(temp) || list.contains(temp2) || s.equals(ss)) continue;
	        else {
	            list.add(temp);
	            answer++;
	        }
	    }
        
        return answer;
    }
}
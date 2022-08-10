class Solution {
    public int solution(String dartResult) {
        String temp = "";
        int[] score = new int[3];
        int idx = 0;
        String[] str = dartResult.split("");
        
        for (int i = 0; i < str.length; i++){
            if (str[i].charAt(0) >= 48 && str[i].charAt(0) <= 57){
                temp += str[i];
            } else if (str[i].equals("S")){
                score[idx++] = Integer.parseInt(temp);
                temp = "";
            } else if (str[i].equals("D")){
                score[idx++] = (int)Math.pow(Integer.parseInt(temp), 2);
                temp = "";
            } else if (str[i].equals("T")){
                score[idx++] = (int)Math.pow(Integer.parseInt(temp), 3);
                temp = "";
            } else if (str[i].equals("*")){
                if (idx > 1){
                    score[idx-1] *= 2;
                    score[idx-2] *= 2;
                } else
                    score[idx-1] *= 2;
            } else if (str[i].equals("#")){
                score[idx-1] *= -1;
            }
        }
        
        return score[0] + score[1] + score[2];
    }
}
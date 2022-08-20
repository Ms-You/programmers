import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        List<String> alpha = new ArrayList<>(Arrays.asList("R", "T", "C", "F", "J", "M", "A", "N"));
        int[] num = {0, 0, 0, 0, 0, 0, 0, 0};
        
        for (int i = 0; i < survey.length; i++){
            if (4-choices[i] > 0)
                num[alpha.indexOf(survey[i].split("")[0])] += 4-choices[i];
            else
                num[alpha.indexOf(survey[i].split("")[1])] += choices[i]-4;
        }
        
        sb.append(num[alpha.indexOf("T")] > num[alpha.indexOf("R")] ? "T" : "R");
        sb.append(num[alpha.indexOf("F")] > num[alpha.indexOf("C")] ? "F" : "C");
        sb.append(num[alpha.indexOf("M")] > num[alpha.indexOf("J")] ? "M" : "J");
        sb.append(num[alpha.indexOf("N")] > num[alpha.indexOf("A")] ? "N" : "A");
        
        return sb.toString();
    }
}
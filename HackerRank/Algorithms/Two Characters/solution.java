import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static int M;
    static List<Character> input;
    static int answer = 0;
    private static void comb(int start, int cnt, char[] selected, String s) {
        if (M == cnt) {
            String temp = s;
            
            for (int i = 0; i < M; i++) {
                temp = temp.replaceAll("[" + selected[i] + "]", "");
            }
            
            if (isAlternated(temp)) {
                answer = Math.max(answer, temp.length());
            }
            
            return ;
        }
        
        for (int i = start; i < input.size(); i++) {
            selected[cnt] = input.get(i);
            comb(i+1, cnt+1, selected, s);
        }
    }
    
    private static boolean isAlternated(String temp) {
        if (temp.length() <= 2) {
            return true;
        }
        
        for (int i = 0; i < temp.length()-2; i++) {
            if (temp.charAt(i) != temp.charAt(i+2)) {
                return false;
            }
        }
        
        return true;
    }
    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
    // Write your code here
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        
        if (set.size() == 1) {
            return 0;
        }
        
        M = set.size() - 2;
        input = new ArrayList<>(set);
        
        comb(0, 0, new char[M], s);
        
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

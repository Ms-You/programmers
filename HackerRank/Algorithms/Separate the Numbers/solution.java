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

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
        long initNum = 0;
        
        for (int i = 1; i <= s.length()/2; i++) {
            long prevNum = Long.parseLong(s.substring(0, i));
            initNum = prevNum;
            boolean isValid = true;
            int idx = i;
            
            while (idx < s.length()) {
                prevNum++;
                String nextNum = String.valueOf(prevNum);
                int nextLen = nextNum.length();
                
                if (idx + nextLen <= s.length() && nextNum.equals(s.substring(idx, idx+nextLen))) {
                    idx += nextLen;
                } else {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("YES " + initNum);
                return;
            }
        }
        
        System.out.println("NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

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

    private static String madeByDecent(int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int threeCnt = 0; threeCnt <= n/5; threeCnt++) {
            int remains = n - (threeCnt*5);
            
            if (remains % 3 == 0) {
                for (int i = 0; i < remains/3; i++) {
                    sb.append("555");
                }
                
                for (int i = 0; i < threeCnt; i++) {
                    sb.append("33333");
                }
                
                return sb.toString();
            }
        }
        
        return "-1";
    }

    /*
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
    // Write your code here
        System.out.println(madeByDecent(n));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        int cnt = 0;
        for (int i = p; i <= q; i++) {
            int sum = 0;
            
            long powNum = (long) i * i;
            String str = Long.toString(powNum);
            
            int originLen = Integer.toString(i).length();
            int powLen = str.length();
            
            String l = str.substring(0, powLen - originLen);
            String r = str.substring(powLen-originLen);
            
            if (l.equals("")) {
                sum = Integer.parseInt(r);
            } else {
                sum = Integer.parseInt(l) + Integer.parseInt(r);
            }
            
            if (sum == i) {
                cnt++;
                System.out.print(i + " ");
            }
        }
        
        if (cnt == 0) {
            System.out.println("INVALID RANGE");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}

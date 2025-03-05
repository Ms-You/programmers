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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
        int idx = 0;
        
        while (idx < s.length() && idx < t.length() && s.charAt(idx) == t.charAt(idx)) {
            idx++;
        }
        
        int diff = (s.length() - idx) + (t.length() - idx);
        
        if (k >= diff) {
	    // 홀짝 여부가 같아야 함
            if ((k % 2 == 0 && diff % 2 == 0) || (k % 2 != 0 && diff % 2 != 0)) {
                return "Yes";
            }
        }
        
	// 문자열이 없는 경우에는 지워도 상관 없기 때문에, aba aba 7인 경우에 Yes
        if (s.length() + t.length() <= k) {
            return "Yes";
        }
        
        return "No";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

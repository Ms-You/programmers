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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
        char[] arr = b.toCharArray();
        int startIdx = -1;
        
        if (b.indexOf("_") != -1) {
            Arrays.sort(arr);
            startIdx = new String(arr).indexOf("_");
        }

        int end = startIdx == -1 ? b.length() : startIdx;
        
        if (end == 0) {
            return "YES";
        }
        
        int count = 1;
        for (int i = 1; i < end; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                if (count == 1) {
                    break;
                } else {
                    count = 1;
                }
            }
        }

        return count == 1 ? "NO" : "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

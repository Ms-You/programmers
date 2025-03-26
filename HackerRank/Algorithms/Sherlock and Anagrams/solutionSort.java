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
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
        int count = 0;
        int len = s.length();
        Map<String, Integer> anagramCountMap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= len-i; j++) {
                String str = s.substring(i, i+j);
                char[] alpha = str.toCharArray();
                
                Arrays.sort(alpha);
                
                String sortedStr = new String(alpha);
                
                anagramCountMap.put(sortedStr, anagramCountMap.getOrDefault(sortedStr, 0) + 1);
            }
        }
        
        for (int value : anagramCountMap.values()) {
            count += (value * (value-1) / 2);
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

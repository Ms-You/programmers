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
    private static boolean isAnagram(String s1, String s2) {
        int[] alpha = new int[26];
        
        for (char ch : s1.toCharArray()) {
            alpha[ch-'a']++;
        }
        
        for (char ch : s2.toCharArray()) {
            alpha[ch-'a']--;
        }
        
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
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
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len-i; j++) {
                String s1 = s.substring(j, j+i);
                
                for (int k = j+1; k <= len-i; k++) {
                    String s2 = s.substring(k, k+i);
                    
                    if (isAnagram(s1, s2)) {
                        count++;
                    }
                }
            }
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

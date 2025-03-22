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
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here
        int result = 0;
        
        List<String> list1 = new ArrayList<>(Arrays.asList(s1.split("")));
        List<String> list2 = new ArrayList<>(Arrays.asList(s2.split("")));
        
        for (int i = 0; i < s2.length(); i++) {
            if (list1.contains(s2.substring(i, i+1))) {
                list1.remove(s2.substring(i, i+1));
                result++;
            }
        }
        
        for (int i = 0; i < s1.length(); i++) {
            if (list2.contains(s1.substring(i, i+1))) {
                list2.remove(s1.substring(i, i+1));
                result++;
            }
        }
        
        result = s1.length() + s2.length() - result;
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

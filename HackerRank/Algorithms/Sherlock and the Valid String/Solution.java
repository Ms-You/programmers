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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        int[] alpha = new int[26];
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            alpha[ch-'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                countMap.put(i, alpha[i]);
            }
        }
        
        Collection<Integer> counts = countMap.values();
        Set<Integer> countSet = new HashSet<>(counts);
        
        if (countSet.size() == 1) {
            return "YES";
        } else if (countSet.size() > 2) {
            return "NO";
        } else {    // countSet.size() == 2
            List<Integer> countList = new ArrayList<>(countSet);
            int min = 0, max = 0;
            
            if (countList.get(0) < countList.get(1)) {
                min = countList.get(0);
                max = countList.get(1);
            }
            
            if (max-min == 1 && Collections.frequency(counts, max) == 1) {
                return "YES";
            } else if (min == 1 && Collections.frequency(counts, min) == 1) {
                return "YES";
            } else {
                return "NO";
            }   
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

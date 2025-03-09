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

    private static void reverseOrder(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
        if (w.length() <= 1) {
            return "no answer";
        }
        
        char[] arr = w.toCharArray();
        int len = arr.length;
        
        int idx = len-2;
        while (idx >= 0 && arr[idx] >= arr[idx+1]) {
            idx--;
        }
        
        if (idx == -1) {
            return "no answer";
        }
        
        int nextIdx = len-1;
        while (arr[nextIdx] <= arr[idx]) {
            nextIdx--;
        }
        
        char temp = arr[nextIdx];
        arr[nextIdx] = arr[idx];
        arr[idx] = temp;
        
        reverseOrder(arr, idx+1, len-1);
        
        return new String(arr);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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

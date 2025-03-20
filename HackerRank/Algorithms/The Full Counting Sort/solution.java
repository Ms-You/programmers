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
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
    // Write your code here
        int max = Integer.MIN_VALUE;
        
        for (List<String> element : arr) {
            int value = Integer.parseInt(element.get(0));
            max = Math.max(max, value);
        }
        
        List<String>[] list = new ArrayList[max+1];
        
        for (int i = 0; i <= max; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < arr.size()/2; i++) {
            arr.get(i).set(1, "-");
        }
        
        for (List<String> element : arr) {
            int value = Integer.parseInt(element.get(0));
            list[value].add(element.get(1));
        }
        
        StringBuilder sb = new StringBuilder();
        for (List<String> element : list) {
            for (String str : element) {
                sb.append(str + " ");
            }
        }
        
        System.out.println(sb.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}

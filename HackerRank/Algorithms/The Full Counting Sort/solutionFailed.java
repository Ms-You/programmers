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
     * 첫 번째 방법 => n이 1000000일 떄 시간 초과
     */

    public static void countSort(List<List<String>> arr) {
    // Write your code here
        List<List<String>> countList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.size()/2; i++) {
            arr.get(i).set(1, "-");
        }
        
        for (List<String> element : arr) {
            int value = Integer.parseInt(element.get(0));
            
            max = Math.max(max, value);
        }
        
        for (int i = 0; i <= max; i++) {
            countList.add(new ArrayList<>());
        }
        
        for (List<String> element : arr) {
            int value = Integer.parseInt(element.get(0));
            countList.get(value).add(element.get(1));
        }
        
        List<String> sortedList = new ArrayList<>();
        for (List<String> element : countList) {
            sortedList.addAll(element);
        }
        
        for (String str : sortedList) {
            System.out.print(str + " ");
        }
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

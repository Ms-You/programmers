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
    
    private static void sort(List<Integer> arr, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot);
        sort(arr, pivot+1, right);
    }
    
    private static int partition(List<Integer> arr, int left, int right) {
        int l = left-1, r = right+1;
        int pivot = arr.get((left + right)/2);
        
        while (true) {
            do {
                l++;
            } while (arr.get(l) < pivot);
            
            do {
                r--;
            } while (l <= r && arr.get(r) > pivot);
            
            if (l >= r) {
                return r;
            }
            
            swap(arr, l, r);
        }
    }
    
    private static void swap(List<Integer> arr, int l, int r) {
        int temp = arr.get(l);
        
        arr.set(l, arr.get(r));
        arr.set(r, temp);
    }

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
        sort(arr, 0, arr.size()-1);
        
        return arr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

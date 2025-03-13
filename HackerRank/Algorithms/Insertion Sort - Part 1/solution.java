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

    private static void printArr(int idx, List<Integer> arr) {
        for (int i = 0; i < idx; i++) {
            System.out.print(arr.get(i) + " ");
        }
        
        System.out.print(arr.get(idx-1) + " ");
        
        for (int i = idx+1; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        
        System.out.println();
    }
    
    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        int idx = n-1;
        
        while (idx > 0 && arr.get(idx) < arr.get(idx-1)) {
            printArr(idx, arr);
            
            int temp = arr.get(idx);
            arr.set(idx, arr.get(idx-1));
            arr.set(idx-1, temp);
            
            idx--;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

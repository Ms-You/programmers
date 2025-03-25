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
    private static boolean isSorted(List<Integer> arr) {
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i) > arr.get(i+1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static void swap(List<Integer> arr, int start, int end) {
        int temp = arr.get(start);
        arr.set(start, arr.get(end));
        arr.set(end, temp);
    }
    
    private static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    
    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
    // Write your code here
        if (isSorted(arr)) {
            System.out.println("yes");
            return;
        }
        
        int start = -1, end = -1;
        
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i) > arr.get(i+1)) {
                start = i;
                break;
            }
        }
        
        for (int i = arr.size()-1; i > 0; i--) {
            if (arr.get(i) < arr.get(i-1)) {
                end = i;
                break;
            }
        }
        
        if (end == -1) {
            end = arr.size()-1;
        }
        
        swap(arr, start, end);
        
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (start+1) + " " + (end+1));
            return;
        }
        
        // rollback
        swap(arr, start, end);
        reverse(arr, start, end);
        
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (start+1) + " " + (end+1));
            return;
        }
        
        System.out.println("no");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}

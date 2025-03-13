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

    private static void rotation(int idx, List<Integer> A) {
        int a = A.get(idx);
        int b = A.get(idx+1);
        int c = A.get(idx+2);
        
        int min = Math.min(a, Math.min(b, c));
        
        while (min != A.get(idx)) {
            int temp = a;
            a = b;
            b = c;
            c = temp;
            
            A.set(idx, a);
            A.set(idx+1, b);
            A.set(idx+2, c);
        }
    }
    
    /*
     * Complete the 'larrysArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static String larrysArray(List<Integer> A) {
    // Write your code here
        List<Integer> copyA = new ArrayList<>(A);
        Collections.sort(copyA);
        
        while (true) {
            boolean flag = true;
            
            for (int i = 0; i < A.size()-2; i++) {
                if (A.get(i) > A.get(i+1) || A.get(i) > A.get(i+2)) {
                    rotation(i, A);
                    flag = false;
                }
            }
            
            if (flag) {
                break;
            }
        }
        
        if (copyA.equals(A)) {
            return "YES";
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.larrysArray(A);

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

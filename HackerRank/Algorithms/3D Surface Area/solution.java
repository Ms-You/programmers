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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     * 다시 풀어볼 것
     */

    public static int surfaceArea(List<List<Integer>> A) {
    // Write your code here
        int H = A.size();
        int W = A.get(0).size();
        int totalSurface = H * W * 2;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int now = A.get(i).get(j);
                
                if (j == 0) {
                    totalSurface += now;
                }
                
                if (j == W-1) {
                    totalSurface += now;
                }
                
                if (j > 0 && j < W) {
                    totalSurface += Math.abs(now - A.get(i).get(j-1));
                }
                
                if (i == 0) {
                    totalSurface += now;
                }
                
                if (i == H-1) {
                    totalSurface += now;
                }
                
                if (i > 0 && i < H) {
                    totalSurface += Math.abs(now - A.get(i-1).get(j));
                }
            }
        }
        
        return totalSurface;
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

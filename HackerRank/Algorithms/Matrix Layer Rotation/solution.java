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
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
    // Write your code here
        int rowSize = matrix.size();
        int colSize = matrix.get(0).size();
        int minSize = Math.min(rowSize, colSize)/2;
        List<List<Integer>> rotatedMatrix = new ArrayList<>();
        
        for (int layer = 0; layer < minSize; layer++) {
            List<Integer> currentMatrix = new ArrayList<>();
            
            // top
            for (int i = layer; i < colSize-layer; i++) {
                currentMatrix.add(matrix.get(layer).get(i));
            }
            
            // right
            for (int i = layer+1; i < rowSize-layer-1; i++) {
                currentMatrix.add(matrix.get(i).get(colSize-layer-1));
            }
            
            // bottom
            for (int i = colSize-layer-1; i >= layer; i--) {
                currentMatrix.add(matrix.get(rowSize-layer-1).get(i));
            }
            
            // left
            for (int i = rowSize-layer-2; i > layer; i--) {
                currentMatrix.add(matrix.get(i).get(layer));
            }
            
            rotatedMatrix.add(currentMatrix);
        }
        
        for (int layer = 0; layer < minSize; layer++) {
            List<Integer> currentMatrix = rotatedMatrix.get(layer);
            int len = currentMatrix.size();
            int realR = r % len;
            int idx = 0;
            
            // top
            for (int i = layer; i < colSize-layer; i++) {
                matrix.get(layer).set(i, currentMatrix.get((idx + realR) % len));
                idx++;
            }
            
            // right
            for (int i = layer+1; i < rowSize-layer-1; i++) {
                matrix.get(i).set(colSize-layer-1, currentMatrix.get((idx + realR) % len));
                idx++;
            }
            
            // bottom
            for (int i = colSize-layer-1; i >= layer; i--) {
                matrix.get(rowSize-layer-1).set(i, currentMatrix.get((idx + realR) % len));
                idx++;
            }
            
            // left
            for (int i = rowSize-layer-2; i > layer; i--) {
                matrix.get(i).set(layer, currentMatrix.get((idx + realR) % len));
                idx++;
            }
        }
        
        for (List<Integer> list : matrix) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

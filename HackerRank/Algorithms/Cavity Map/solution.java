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
    private static boolean checkDeeper(char num, char num1, char num2, char num3, char num4) {
        int n = Character.getNumericValue(num);
        int n1 = Character.getNumericValue(num1);
        int n2 = Character.getNumericValue(num2);
        int n3 = Character.getNumericValue(num3);
        int n4 = Character.getNumericValue(num4);
        
        if (n > n1 && n > n2 && n > n3 && n > n4) {
            return true;
        }
        
        return false;
    }

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
        for (int i = 1; i < grid.size()-1; i++) {
            for (int j = 1; j < grid.get(i).length()-1; j++) {
                if (checkDeeper(grid.get(i).charAt(j), grid.get(i-1).charAt(j), grid.get(i).charAt(j-1), grid.get(i+1).charAt(j), grid.get(i).charAt(j+1))) {
                    grid.set(i, grid.get(i).substring(0, j) + "X" + grid.get(i).substring(j+1));
                }
            }
        }
        
        return grid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

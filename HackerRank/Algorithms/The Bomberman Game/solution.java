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
    private static List<String> lauchBomb(List<String> grid) {
        List<String> fillBombList = new ArrayList<>();
        
        for (int i = 0; i < grid.size(); i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < grid.get(i).length(); j++) {
                sb.append("O");
            }
            
            fillBombList.add(sb.toString());
        }
        
        return fillBombList;
    }
    
    private static String replaceChar(String str, int idx, char ch) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(idx, ch);
        
        return sb.toString();
    }
    
     private static List<String> explodeBomb(List<String> grid) {
        List<String> fillBombList = lauchBomb(grid);
        List<int[]> bombLocationList = new ArrayList<>();
        
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    bombLocationList.add(new int[]{i, j});
                }
            }
        }
        
        for (int[] location : bombLocationList) {
            int i = location[0];
            int j = location[1];
            
            fillBombList.set(i, replaceChar(fillBombList.get(i), j, '.'));
            
            if (i > 0) {
                fillBombList.set(i-1, replaceChar(fillBombList.get(i-1), j, '.'));
            }
            
            if (i < grid.size()-1) {
                fillBombList.set(i+1, replaceChar(fillBombList.get(i+1), j, '.'));
            }
            
            if (j > 0) {
                fillBombList.set(i, replaceChar(fillBombList.get(i), j-1, '.'));
            }
            
            if (j < grid.get(i).length()-1) {
                fillBombList.set(i, replaceChar(fillBombList.get(i), j+1, '.'));
            }
        }
        
        return fillBombList;
    }
    
    
    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
        if (n == 1) {
            return grid;
        }
        
        if (n % 2 == 0) {
            return lauchBomb(grid);
        }
        
        List<String> firstGrid = explodeBomb(grid);
        List<String> secondGrid = explodeBomb(firstGrid);
        
        return n % 4 == 3 ? firstGrid : secondGrid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

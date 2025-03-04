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
    static List<Integer> countList = new ArrayList<>();
    static int M = 2;
    
    private static void comb(int start, int cnt, String[] selected, List<String> topic) {
        if (cnt == M) {
            int countOfOne = 0;
            
            for (int i = 0; i < selected[0].length(); i++) {
                if (selected[0].charAt(i) == '1' || selected[1].charAt(i) == '1') {
                    countOfOne++;
                }
            }
            
            countList.add(countOfOne);
            return;
        }
        
        for (int i = start; i < topic.size(); i++) {
            selected[cnt] = topic.get(i);
            comb(i+1, cnt+1, selected, topic);
        }
    }
    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
        comb(0, 0, new String[M], topic);
        
        Collections.sort(countList, Collections.reverseOrder());
        
        int maxCount = countList.get(0);
        int cnt = 0;
        
        for (int count : countList) {
            if (maxCount == count) {
                cnt++;
            } else {
                break;
            }
        }
        
        return Arrays.stream(new int[]{maxCount, cnt})
                .boxed()
                .collect(Collectors.toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

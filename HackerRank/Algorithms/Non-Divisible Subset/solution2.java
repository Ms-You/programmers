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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        int result = 0;
        int[] arr = new int[k];
        
	// 1. 나머지 개수를 구하기
        for (int i = 0; i < s.size(); i++) {
            arr[s.get(i) % k]++;
        }
        
	// 2. 나머지가 0인 경우는 두 개 이상 더하면 k의 배수이기 때문에 1개만 포함시킬 것
        if (arr[0] > 0) {
            result++;
        }
        
	// 3. k가 짝수이고, 나머지가 k/2인 경우도 두 개 이상 더하면 k의 배수이기 때문에 1개만 포함시킬 것
        if (k % 2 == 0 && arr[k/2] > 0) {
            result++;
        }
        
	// 4. 두 나머지의 합이 k로 나누어 떨어지는 경우, 나머지 중 더 큰 값을 포함시킬 것
        for (int i = 1; i <= (k-1)/2; i++) {
            result += Math.max(arr[i], arr[k-i]);
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

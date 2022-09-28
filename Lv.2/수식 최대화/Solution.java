import java.util.*;
import java.util.stream.*;
class Solution {
    
    static List<Long> number = new ArrayList<>();
    static List<String> oper;
    
    public static void multiFirst(){
        while(oper.contains("*")){
            int idx = oper.indexOf("*");
            number.add(idx, number.remove(idx) * number.remove(idx));
            oper.remove(idx);
        }
    }
    
    public static void plusFirst(){
        while(oper.contains("+")){
            int idx = oper.indexOf("+");
            number.add(idx, number.remove(idx) + number.remove(idx));
            oper.remove(idx);
        }
    }
    
    public static void minusFirst(){
        while(oper.contains("-")){
            int idx = oper.indexOf("-");
            number.add(idx, number.remove(idx) - number.remove(idx));
            oper.remove(idx);
        }
    }
    
    public long solution(String expression) {
        
        long[] nums = Arrays.stream(expression.replaceAll("[^0-9]", " ").split(" ")).mapToLong(Long::parseLong).toArray();
        String[] opers = expression.replaceAll("[0-9]", "").split("");
        long max = 0;
        
        // * + -
        for(long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        multiFirst();
        plusFirst();
        minusFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        // * - +
        for (long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        multiFirst();
        minusFirst();
        plusFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        // + * -
        for (long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        plusFirst();
        multiFirst();
        minusFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        // + - *
        for (long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        plusFirst();
        minusFirst();
        multiFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        // - * +
        for (long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        minusFirst();
        multiFirst();
        plusFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        // - + *
        for (long n : nums)
            number.add(n);
        oper = new ArrayList<>(Arrays.asList(opers));
        minusFirst();
        plusFirst();
        multiFirst();
        max = Math.max(max, (long)Math.abs(number.remove(0)));
        
        return max;
    }
}
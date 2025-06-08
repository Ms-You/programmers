class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        String[] str = new String[n];

        for (int i = 1; i <= n; i++) {
            str[i-1] = Integer.toString(i);
        }

        Arrays.sort(str, (s1, s2) -> s1.compareTo(s2));

        for (String s : str) {
            answer.add(Integer.parseInt(s));
        }

        return answer;
    }
}
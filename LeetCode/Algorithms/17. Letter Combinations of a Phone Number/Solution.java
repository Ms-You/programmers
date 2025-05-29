class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if (digits.length() == 0) {
            return answer;
        }

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        answer.add("");

        for (char digit : digits.toCharArray()) {
            String letter = letters[digit - '0'];

            List<String> temp = new ArrayList<>();
            for (String ans : answer) {
                for (char ch : letter.toCharArray()) {
                    temp.add(ans + ch);
                }
            }

            answer = temp;
        }

        return answer;
    }
}
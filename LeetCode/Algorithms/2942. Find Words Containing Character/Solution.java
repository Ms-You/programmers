class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            boolean flag = false;
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                answer.add(i);
            }
        }

        return answer;
    }
}
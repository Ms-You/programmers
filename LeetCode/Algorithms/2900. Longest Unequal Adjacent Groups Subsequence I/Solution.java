class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> answer = new ArrayList<>();

        int digit = groups[0];
        answer.add(words[0]);

        for (int i = 1; i < groups.length; i++) {
            if (digit != groups[i]) {
                digit = groups[i];
                answer.add(words[i]);
            }
        }

        return answer;
    }
}
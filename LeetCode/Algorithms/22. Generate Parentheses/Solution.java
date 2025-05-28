class Solution {
    private static void dfs(List<String> list, String str, int size) {
        if (str.length() == size) {
            if (isValid(str)) {
                list.add(str);
            }
            return;
        }

        dfs(list, str+"(", size);
        dfs(list, str+")", size);
    }

    private static boolean isValid(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                sum++;
            } else {
                sum--;
            }

            if (sum < 0) {
                return false;
            }
        }

        return sum == 0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        dfs(list, "", n*2);

        return list;
    }
}
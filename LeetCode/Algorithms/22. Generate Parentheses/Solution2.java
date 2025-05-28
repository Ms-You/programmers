class Solution {
    private static void dfs(List<String> list, String str, int open, int close, int n) {
        if (str.length() == n*2) {
            list.add(str);
            return;
        }

        if (open < n) {
            dfs(list, str+"(", open+1, close, n);
        }

        if (close < open) {
            dfs(list, str+")", open, close+1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        dfs(list, "", 0, 0, n);

        return list;
    }
}
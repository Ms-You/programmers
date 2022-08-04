class Solution {
    public long solution(long n) {
        Double root = Math.sqrt(n);

        if (root == root.intValue())
            return (long) Math.pow(root+1, 2);

        return -1;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s1 = strs[0];
        boolean flag = true;
        
        for (int i = 1; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] arr1 = s1.toCharArray();
            char[] arr2 = strs[i].toCharArray();

            int len = Math.min(arr1.length, arr2.length);
            
            for (int j = 0; j < len; j++) {
                if (arr1[j] == arr2[j]) {
                    sb.append(arr1[j]);
                } else {
                    break;
                }
            }

            if (sb.length() != 0) {
                s1 = sb.toString();
            } else {
                flag = false;
                break;
            }
        }

        return flag ? s1 : "";
    }
}
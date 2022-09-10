class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean flag = true;
        
        for (int i = 0; i < skill_trees.length; i++){
            for (int j = 1; j < skill.length(); j++){
                int prevIdx = skill_trees[i].indexOf(skill.charAt(j-1));
                int nextIdx = skill_trees[i].indexOf(skill.charAt(j));
                if (prevIdx != -1 && nextIdx == -1) continue;
                else if ((prevIdx == -1 && nextIdx != -1) || prevIdx > nextIdx){
                    flag = false;
                    break;
                }
            }
            if (!flag) flag = true;
            else answer++;
        }
        
        return answer;
    }
}
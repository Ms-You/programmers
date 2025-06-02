class Solution {
    public int candy(int[] ratings) {
        int answer = 0;
        int[] people = new int[ratings.length];
        
        for (int i = 0; i < people.length; i++) {
            people[i] = 1;
        }

        for (int i = 0; i < people.length-1; i++) {
            if (ratings[i] < ratings[i+1]) {
                people[i+1] = people[i] + 1;
            }
        }

        for (int i = people.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                people[i] = Math.max(people[i], people[i+1]+1);
            }
        }

        for (int p : people) {
            answer += p;
        }

        return answer;
    }
}
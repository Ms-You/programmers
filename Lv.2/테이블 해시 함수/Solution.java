import java.util.*;
class Solution {
    // 버블 정렬 사용
    private static void bubbleSort(List<int[]> list, int col){
        for (int i = 1; i < list.size(); i++){
		    for (int j = 0; j < list.size()-i; j++){
		        if (list.get(j)[col-1] > list.get(j+1)[col-1]){
		            int[] temp = list.get(j);
		            list.remove(j);
		            list.add(j+1, temp);
		        } else if (list.get(j)[col-1] == list.get(j+1)[col-1]){
		            if (list.get(j)[0] < list.get(j+1)[0]){
		                int[] temp = list.get(j);
		                list.remove(j);
		                list.add(j+1, temp);
		            }
		        }
		    }
		}
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++)
            list.add(data[i]);
            
        bubbleSort(list, col);
        
        for (int i = row_begin; i < row_end+1; i++){
            int si = 0;
            for (int j = 0; j < list.get(i-1).length; j++){
                si += list.get(i-1)[j] % i;
            }
            answer = answer ^ si;
        }
        
        return answer;
    }
}
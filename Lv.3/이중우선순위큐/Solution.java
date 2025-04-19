import java.util.*;
class Heap {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    private Map<Integer, Integer> countMap;
    
    public Heap() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        countMap = new HashMap<>();
    }
    
    public boolean isEmpty() {
        return countMap.isEmpty();
    }
    
    public void add(int val) {
        minHeap.add(val);
        maxHeap.add(val);
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
    }
    
    public void removeMin() {
        remove(minHeap);
    }
    
    public void removeMax() {
        remove(maxHeap);
    }
    
    private void remove(Queue<Integer> heap) {
        if (heap.isEmpty()) {
            return;
        }
        
        int val = heap.poll();
        countMap.put(val, countMap.get(val) - 1);
        
        if (heap == minHeap) {
            maxHeap.remove(val);
        } else {
            minHeap.remove(val);
        }
    }
    
    public int getMin() {
        while (!minHeap.isEmpty()) {
            int val = minHeap.peek();
            
            if (countMap.containsKey(val) && countMap.get(val) > 0) {
                return val;
            } else {
                minHeap.poll();
            }
        }
        
        return 0;
    }
    
    public int getMax() {
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.peek();
            
            if (countMap.containsKey(val) && countMap.get(val) > 0) {
                return val;
            } else {
                maxHeap.poll();
            }
        }
        
        return 0;
    }
    
}
class Solution {
    public int[] solution(String[] operations) {
        Heap heap = new Heap();
        
        for (String op : operations) {
            if (op.charAt(0) == 'I') {  // 값 추가
                int val = Integer.parseInt(op.substring(2));
                
                heap.add(val);
            } else {
                if (op.charAt(2) == '-') {  // 최솟값 제거
                    heap.removeMin();
                } else {    // 최댓값 제거
                    heap.removeMax();
                }
            }
        }
        
        if (heap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{heap.getMax(), heap.getMin()};
        }
    }
}
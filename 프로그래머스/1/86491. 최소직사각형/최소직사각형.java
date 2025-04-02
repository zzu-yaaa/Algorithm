import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        PriorityQueue<Integer> width = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<sizes.length; i++){
            width.offer(Math.max(sizes[i][0], sizes[i][1]));
            height.offer(Math.min(sizes[i][0], sizes[i][1]));
        }
        
        int answer = width.poll() * height.poll();
        return answer;
    }
}
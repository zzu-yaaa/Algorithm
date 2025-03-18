import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Double> q = new LinkedList<>();
        for (int i=0 ; i<progresses.length; i++){
            double days = Math.ceil((100 - progresses[i]) / (double)speeds [i]);
            q.offer(days);
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            double cur = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && cur >= q.peek()){
                cnt += 1;
                q.poll();
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
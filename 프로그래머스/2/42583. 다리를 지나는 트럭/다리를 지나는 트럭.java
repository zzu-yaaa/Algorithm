import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }

        int answer = 0;
        int bridge_weight = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            answer += 1;
            bridge_weight -= q.poll();
            
            int truck = truck_weights[idx];
            if(bridge_weight + truck <= weight){
                bridge_weight += truck;
                q.offer(truck);
                idx += 1;
            }
            else{
                q.offer(0);
            }
        }
           
        return answer + bridge_length;
    }
}
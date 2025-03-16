import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new LinkedList<>();
        int cur = arr[0];
        q.add(cur);
        
        for(int i=1; i< arr.length; i++){
            if(cur != arr[i]){
                cur = arr[i];
                q.add(cur);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            answer.add(q.poll());        
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
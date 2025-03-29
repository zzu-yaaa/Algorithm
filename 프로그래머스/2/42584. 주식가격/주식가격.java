import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<prices.length; i++){
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt += 1;
                if(prices[i] > prices[j]) break;
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
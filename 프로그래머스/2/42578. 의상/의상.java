import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] temp : clothes){
            map.put(temp[1], map.getOrDefault(temp[1],0)+1);
        }
        
        int answer = 1;
        for(String key: map.keySet()){
            System.out.println(key + map.get(key));
            answer *= map.get(key)+1;
        }
        answer = answer - 1;
        
        return answer;
    }
}
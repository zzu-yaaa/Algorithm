import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String temp: participant){
           map.put(temp,map.getOrDefault(temp,0)+1);
        }
        
        for(String temp: completion){
           if (map.get(temp) - 1 == 0){
               map.remove(temp);
           }
            else{
                map.put(temp,map.get(temp) - 1);
            }
        }
        
        for(String ans: map.keySet()){
            answer = ans;
        }
        return answer;
    }
}
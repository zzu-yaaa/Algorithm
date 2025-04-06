import java.util.*;

class Solution {
    public ArrayList<String> array = new ArrayList<>();
    
    public int solution(int[] numbers, int target) {
        func("", numbers.length);
        
                int answer = 0;

        for(String temp : array){
            int sum = 0;
            for(int i=0; i<numbers.length; i++){
                if(temp.charAt(i) == '+'){
                    sum += numbers[i];
                }
                else{
                    sum -= numbers[i];
                }
            }
            if(sum == target){
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void func(String str, int len){
        if(str.length() == len){
            array.add(str);
            return;
        }
        
        func(str+"+", len);
        func(str+"-", len);
    }
}
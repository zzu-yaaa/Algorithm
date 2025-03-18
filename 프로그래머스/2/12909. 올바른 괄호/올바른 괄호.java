import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){            
            if(s.charAt(i) == '('){
                stack.push(1);
            }
            else {
                if(i == 0){
                    return false;
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}
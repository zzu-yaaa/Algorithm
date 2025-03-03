import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        ArrayList<String> list = new ArrayList<>();
        for(String temp : phone_book){
            list.add(temp);
        }
        Collections.sort(list);
        
        for(int i=0; i<phone_book.length-1; i++){
            String prefix = list.get(i);
            String phone = list.get(i+1);
            
            if(prefix.length() > phone.length()){
                continue;
            }
            
            if(prefix.equals(phone.substring(0,prefix.length()))){
                return false;
            }
            
        }

        return answer;

    }
}
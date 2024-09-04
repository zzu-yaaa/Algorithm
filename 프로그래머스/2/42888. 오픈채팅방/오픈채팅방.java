import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nickname = new HashMap<>();
        
        for(String s : record){
            String[] in = s.split(" ");
            if(in[0].equals("Enter") || in[0].equals("Change")){
                nickname.put(in[1], in[2]);
            }
        }
        

        String[] answer = {};
        ArrayList<String> ansList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String s : record){
            String[] in = s.split(" ");
            sb = new StringBuilder();
            if(in[0].equals("Enter")){
                sb.append(nickname.get(in[1]));
                sb.append("님이 들어왔습니다.");
            }
            else if(in[0].equals("Leave")){
                sb.append(nickname.get(in[1]));
                sb.append("님이 나갔습니다.");
            }
            
            String temp = sb.toString();
            if(!temp.isEmpty()){
                ansList.add(temp);
            }

        }
        
        answer = ansList.toArray(new String[ansList.size()]);
        
        return answer;
    }
}
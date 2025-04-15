import java.util.*;

class Solution {
    
    public List<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        int[] vis = new int[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0, vis);
        
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String depart, String route, String[][] tickets, int cnt, int[] vis){
        if(cnt == tickets.length){
            answers.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(vis[i] == 0 && depart.equals(tickets[i][0])){
                vis[i] = 1;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1, vis);
                vis[i] = 0;
            }
        }
        
    }
}
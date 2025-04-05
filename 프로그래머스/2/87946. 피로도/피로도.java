import java.util.*;

class Solution {
    public int answer = -1;
    public int[] vis;
    
    public int solution(int k, int[][] dungeons) {    
        vis = new int[dungeons.length];
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(vis[i] == 1 || k < dungeons[i][0]){
                continue;
            }
            
            vis[i] = 1;
            dfs(cnt+1, k-dungeons[i][1], dungeons);
            vis[i] = 0;            
        }
        
        answer = Math.max(answer, cnt);
        
    }
    
    
}
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        int[] vis = new int[n+1];
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, vis, n, computers);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[] vis, int n, int[][] computers){
        vis[node] = 1;
        
        for(int i=0; i<n; i++){
            if(vis[i] == 0 && computers[node][i] == 1){
                vis[i] = 1;
                dfs(i, vis, n, computers);
            }
        }
    }
}
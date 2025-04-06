import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Set<Integer> used = new HashSet<>();
        for(int i=0; i<n; i++){
            used.add(i);
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(used.contains(i)){
                int[] vis = new int[n];
                dfs(i, vis, n, computers);
                for(int j=0; j<n; j++){
                    if(vis[j] == 1){
                        used.remove(j);
                    }
                }

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
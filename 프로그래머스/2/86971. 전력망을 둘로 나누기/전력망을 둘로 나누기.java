import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        
        //인접리스트 생성
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            int x = wire[0];
            int y = wire[1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int answer = n;

        for(int[] wire : wires){
            int x = wire[0];
            int y = wire[1];
            
            graph.get(x).remove(Integer.valueOf(y)); //remove(y)는 y번째 인덱스 값을 지우기 떄문에 y라는 값 자체를 지울 수 있도록 함
            graph.get(y).remove(Integer.valueOf(y));
            
            int[] vis = new int[n+1];
            int size = dfs(x, vis);
            
            int temp = Math.abs(n - size * 2);
            answer = Math.min(answer, temp);
           
            graph.get(x).add(y);
            graph.get(y).add(x);
            
        }
        
        
        return answer;
    }
    
    public int dfs(int i, int[] vis){
        vis[i] = 1;
        int cnt = 1;
        for(int next : graph.get(i)){
            if(vis[next] == 0){
               cnt += dfs(next, vis);
            }
        }
        return cnt;
              
    }
}
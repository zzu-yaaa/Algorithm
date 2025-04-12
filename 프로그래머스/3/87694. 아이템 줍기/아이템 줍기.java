import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY,
                        int itemX, int itemY) {
        int answer = 0;
        
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        
        int[][] map = new int[101][101];
        int[][] vis = new int[101][101];
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int x2 = rec[2] * 2;
            int y1 = rec[1] * 2;
            int y2 = rec[3] * 2;
            for(int i=x2; i>=x1; i--){
                for(int j=y2; j>=y1; j--){
                    map[i][j] = 1;
                }
            }
        }
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int x2 = rec[2] * 2;
            int y1 = rec[1] * 2;
            int y2 = rec[3] * 2;
            for(int i=x2-1; i>x1; i--){
                for(int j=y2-1; j>y1; j--){
                    map[i][j] = 0;
                }
            }
        }
        
        List<Integer> node = new ArrayList<>();
        //0->x, 1->y, 2->cnt
        Queue<List<Integer>> q = new LinkedList<>();
        node.add(characterX*2);
        node.add(characterY*2);
        vis[characterX*2][characterY*2] = 1;
        node.add(0);
        q.add(node);
        
        while(!q.isEmpty()){
            List<Integer> cur = q.poll();
            
            for(int i=0; i<4; i++){
                int a = cur.get(0) + x[i];
                int b = cur.get(1) + y[i];
                int cnt = cur.get(2) + 1;
                
                if(a < 0 || b < 0 || a > 100 || b > 100){
                    continue;
                }
                
                if(map[a][b] == 1 && vis[a][b] == 0){
                    List<Integer> newNode = new ArrayList<>();
                    newNode.add(a);
                    newNode.add(b);
                    vis[a][b] = cnt;
                    newNode.add(cnt);
                    q.add(newNode);
                }
            }
        }
        
        return vis[itemX*2][itemY*2] / 2;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int[] xValue = {0, 0, -1, 1};
        int[] yValue = {-1, 1, 0, 0};
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] vis = new int[n][m];
        
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        q.add(list);
        vis[0][0] = 1;
        
        while (!q.isEmpty()) {
            ArrayList<Integer> cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int a = cur.get(0) + xValue[i];
                int b = cur.get(1) + yValue[i];
                int cnt = cur.get(2) + 1;

                if (a < 0 || b < 0 || a >= n || b >= m) continue;
                if (maps[a][b] == 0 || vis[a][b] != 0) continue;

                vis[a][b] = cnt;
                ArrayList<Integer> next = new ArrayList<>();
                next.add(a);
                next.add(b);
                next.add(cnt);
                q.add(next);
            }
        }
        
        int answer = vis[n - 1][m - 1];
        return answer == 0 ? -1 : answer;
    }
}
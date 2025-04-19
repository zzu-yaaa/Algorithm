import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[][] graph = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = temp.charAt(j) == '1' ? 1 : 0;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        vis[0][0] = 1;
        q.add(list);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            int x = cur.get(0);
            int y = cur.get(1);
            int cnt = cur.get(2)+1;

            for(int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if (a < 0 || b < 0 || a >= n || b >= m) {
                    continue;
                }

                if(graph[a][b] == 1 && vis[a][b] == 0){
                    list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(cnt);
                    vis[a][b] = cnt;
                    q.add(list);
                }
            }

        }

        bw.write(String.valueOf(vis[n-1][m-1]));

        bw.flush();

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int[][] vis;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int l = Integer.parseInt(br.readLine());
            vis = new int[l+1][l+1];

            String[] temp = br.readLine().split(" ");
            int[] start = new int[2];
            start[0] = Integer.parseInt(temp[0]);
            start[1] = Integer.parseInt(temp[1]);

            temp = br.readLine().split(" ");
            int[] end = new int[2];
            end[0] = Integer.parseInt(temp[0]);
            end[1] = Integer.parseInt(temp[1]);

            BFS(l,start,end);

            bw.write(String.valueOf(vis[end[0]][end[1]]-1)+"\n");
        }

        bw.flush();
    }

    private static void BFS(int l, int[] start, int[] end) {
        ArrayList<Integer> set = new ArrayList<>();
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        int[][] movement = {
                {1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}
        };

        int cnt = 1;
        set.add(start[0]);
        set.add(start[1]);
        set.add(cnt);
        vis[start[0]][start[1]] = cnt;
        q.offer(set);

        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            int x = cur.get(0);
            int y = cur.get(1);

            for(int i=0;i<8;i++){
                int a = x + movement[i][0];
                int b = y + movement[i][1];

                if(a<0 || b<0 || a >= l || b >= l){
                    continue;
                }

                if(vis[a][b] > 0){
                    continue;
                }

                set = new ArrayList<>();
                set.add(a);
                set.add(b);
                set.add(cur.get(2)+1);
                vis[a][b] = cur.get(2)+1;
                q.offer(set);

            }

        }

    }
}

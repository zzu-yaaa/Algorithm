import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int r1 = Integer.parseInt(in[0]);
        int c1 = Integer.parseInt(in[1]);
        int r2 = Integer.parseInt(in[2]);
        int c2 = Integer.parseInt(in[3]);

        int[][] vis = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],-1);
        }

        int[] x = {-2,-2,0,0,2,2};
        int[] y = {-1,+1,-2,+2,-1,+1};

        ArrayList<Integer> set = new ArrayList<>();
        Queue<ArrayList> q = new LinkedList<>();

        set.add(r1);
        set.add(c1);
        set.add(0);
        vis[r1][c1] = 0;
        q.offer(set);

        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();

            for(int i=0;i<6;i++){
                int tempX = cur.get(0) + x[i];
                int tempY = cur.get(1) + y[i];

                if(tempX < 0 || tempX >= n || tempY < 0 || tempY >= n) continue;

                if(vis[tempX][tempY] == -1) {
                    vis[tempX][tempY] = cur.get(2) + 1;
                    set = new ArrayList<>();
                    set.add(tempX);
                    set.add(tempY);
                    set.add(cur.get(2) + 1);

                    q.add(set);
                }
            }
        }

        bw.write(String.valueOf(vis[r2][c2]));

        bw.flush();
        br.close();
        bw.close();

    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[] jump = new int[101];
        int[] vis = new int[101];
        Arrays.fill(vis, -1);

        for(int i=0; i< n+m; i++){
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            jump[a] = b;
        }

        Queue<Integer> q = new LinkedList<>();
        vis[1] = 0;
        q.add(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<=6; i++){
                int next = cur + i;

                if(next > 100) continue;

                if(jump[next] != 0){
                    next = jump[next];
                }

                if(vis[next] == -1){
                    vis[next] = vis[cur] + 1;
                    q.add(next);
                }
            }
        }

        bw.write(vis[100] + "\n");

        bw.flush();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] in = new int[n+1];
        for(int i = 1; i <= n; i++) {
            in[i] = Integer.parseInt(str[i-1]);
        }

        int s = Integer.parseInt(br.readLine());

        int[] vis = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        vis[s] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            //왼쪽
            int temp = cur - in[cur];
            if(temp > 0 && vis[temp] == 0){
                q.offer(temp);
                vis[temp] = 1;
            }
            //오른쪽
            temp = cur + in[cur];
            if(temp <= n && vis[temp] == 0){
                q.offer(temp);
                vis[temp] = 1;
            }
        }

        int result = 0;
        for(int i=1;i<=n;i++) {
            if(vis[i] == 1){
                result+=1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}

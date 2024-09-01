import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            graph[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            graph[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }

        //인접리스트 오름차순으로 정렬
        for(int i=1;i<n+1;i++){
            Collections.sort(graph[i]);
        }

        int[] vis = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        vis[r] = 1;
        q.add(r);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0;i<graph[cur].size();i++){
                if(vis[graph[cur].get(i)] != 0) continue;

                q.add(graph[cur].get(i));
                cnt += 1;
                vis[graph[cur].get(i)] = cnt;
            }
        }

        for(int i = 1; i<=n;i++){
            bw.write(String.valueOf(vis[i])+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

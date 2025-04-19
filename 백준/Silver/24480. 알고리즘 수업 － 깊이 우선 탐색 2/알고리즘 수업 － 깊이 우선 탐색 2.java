import java.io.*;
import java.util.*;

public class Main {
    public static int cnt = 1;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] vis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int r = Integer.parseInt(in[2]);

        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        vis = new int[n+1];

        for(int i=0; i<m; i++){
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0; i<n+1; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        vis[r] = 1;
        dfs(r);

        for(int i=1; i<n+1; i++){
            bw.write(vis[i]+ "\n");
        }

        bw.flush();
    }

    public static void dfs(int node){
        for(int i=0; i<graph.get(node).size(); i++){
            int cur = graph.get(node).get(i);
            if(vis[cur] == 0){
                cnt += 1;
                vis[cur] = cnt;
                dfs(cur);
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main{
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        for(int i = 0 ; i<m;i++){
            String[] inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph[a][b] = graph[b][a] = 1;
        }

        bw.write(String.valueOf(BFW(n)));
        bw.flush();
    }

    private static int BFW(int n){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        int cnt = 0;

        queue.offer(1);
        visited[1] = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i<=n;i++){
                if(visited[i] == 0 && graph[cur][i] == 1){
                    queue.offer(i);
                    visited[i] = 1;
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
}
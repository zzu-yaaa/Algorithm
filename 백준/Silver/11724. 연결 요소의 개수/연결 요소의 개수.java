import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0;i<m;i++){
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            arr[a][b] = arr[b][a] = 1;
        }

        int cnt = 0;
        for(int i = 1; i<=n;i++){
            if(visited[i] == false){
                BFS(n, i);
                cnt++;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void BFS(int n, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i<=n;i++){
                if(arr[cur][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

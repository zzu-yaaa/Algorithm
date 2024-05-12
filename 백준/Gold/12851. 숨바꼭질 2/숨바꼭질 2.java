import java.io.*;
import java.util.*;

public class Main {

    static int[] visited = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);

        if (n >= k) {
            bw.write(String.valueOf(n-k)+"\n"
                    + String.valueOf(1));
            bw.flush();
            return;
        }

        BFS(n,k);

        bw.write(String.valueOf(min)+"\n"
                    + String.valueOf(cnt));

        bw.flush();
    }

    private static void BFS(int x, int k){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(min < visited[cur]) return;

            for(int i=0;i<3;i++){
                int a;
                if(i==0) a = cur-1;
                else if(i==1) a = cur+1;
                else a = cur*2;

                if(a == k){
                    min = visited[cur];
                    cnt+=1;
                }

                if(a<0 || a>100000) continue;

                if(visited[a]==0 || visited[a] == visited[cur]+1){
                    q.offer(a);
                    visited[a] = visited[cur]+1;
                }
            }

        }

    }

}

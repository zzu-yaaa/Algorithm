import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node implements Comparable<Node> {

        int idx;
        int cnt;

        public Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }
        s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        // 시작점이 도착점과 같은 경우
        if(a == b){
            bw.write("0\n");
            bw.flush();
            return;
        }

        Queue<Node> q = new LinkedList<>();
        int[] vis = new int[n+1];

        q.offer(new Node(a, 0));
        vis[a] = 1;

        int result = -1;

        while(!q.isEmpty()){
            Node cur = q.poll();

            // 도착한 경우
            if(cur.idx == b){
                result = cur.cnt;
                break;
            }

            // 점프
            int temp = cur.idx + arr[cur.idx];
            while(temp <= n){
                if(vis[temp] == 0){
                    vis[temp] = 1;
                    q.offer(new Node(temp, cur.cnt + 1));
                }
                temp += arr[cur.idx];
            }

            temp = cur.idx - arr[cur.idx];
            while(temp >= 1){
                if(vis[temp] == 0){
                    vis[temp] = 0;
                    q.offer(new Node(temp, cur.cnt + 1));
                }
                temp -= arr[cur.idx];
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}

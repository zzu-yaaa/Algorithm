import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[][] arr = new int[n+1][m+1];
        int[][] vis = new int[n+1][m+1];

        int gx = 0;
        int gy = 0;
        for(int i=0;i<n;i++){
            in = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(in[j]);
                if(arr[i][j] == 0){
                    vis[i][j] = 0;
                }
                else if(arr[i][j] == 1){
                    vis[i][j] = -1;
                }
                else if(arr[i][j] == 2){
                    gx = i;
                    gy = j;
                    vis[i][j] = 0;
                }
            }

        }

        int[] mx = {0,1,0,-1};
        int[] my = {-1,0,1,0};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(gx,gy,vis[gx][gy]));

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4;i++){
                int a = cur.x + mx[i];
                int b = cur.y + my[i];

                if(a < 0 || a > n || b < 0 || b > m) continue;

                if(vis[a][b] != -1) continue;

                if(arr[a][b] == 1){
                    vis[a][b] = cur.cnt + 1;
                    q.add(new Node(a,b,vis[a][b]));
                }

            }

        }


        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                bw.write(String.valueOf(vis[i][j])+" ");
            }
            bw.write("\n");
        }


        bw.flush();
        br.close();
        bw.close();

    }
}

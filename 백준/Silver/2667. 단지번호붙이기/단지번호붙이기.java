import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] graph;
    public static int[][] vis;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        vis = new int[n][n];

        for(int i=0; i<n; i++){
            String in = br.readLine();
            for(int j=0; j<n; j++){
                int temp = Integer.parseInt(String.valueOf(in.charAt(j)));
                graph[i][j] = temp;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 1 && vis[i][j] == 0){
                    vis[i][j] = 1;
                    dfs(i, j);
                    if(cnt > 0){
                        answer.add(cnt);
                        cnt = 0;
                    }
                }
            }
        }

        bw.write(answer.size() +"\n");
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            bw.write(answer.get(i) +"\n");
        }

        bw.flush();
    }

    public static void dfs(int x, int y){
        cnt += 1;

        int[] moveX = {-1,0,1,0};
        int[] moveY = {0,-1,0,1};

        for(int i=0; i<4; i++){
            int a = x + moveX[i];
            int b = y + moveY[i];

            if(a < 0 || b < 0 || a >= n || b>= n){
                continue;
            }

            if(graph[a][b] == 1 && vis[a][b] == 0){
                vis[a][b] = 1;
                dfs(a,b);
            }
        }
    }
}



import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t>0){
            String[] inputArr = br.readLine().split(" ");
            int m = Integer.parseInt(inputArr[0]);
            int n = Integer.parseInt(inputArr[1]);
            int k = Integer.parseInt(inputArr[2]);
            arr = new int[m+1][n+1];
            visited = new int[m+1][n+1];
            for(int i = 0 ; i < k; i++){
                inputArr = br.readLine().split(" ");
                arr[Integer.parseInt(inputArr[0])][Integer.parseInt(inputArr[1])] = 1;
            }

            int cnt = 0;
            for(int i = 0; i<m;i++){
                for(int j = 0; j<n;j++){
                    if(arr[i][j] == 1 && visited[i][j] == 0){
                        BFS(i,j);
                        cnt += 1;
                    }
                }
            }
            bw.write(String.valueOf(cnt) + "\n");
            t-=1;
        }

        bw.flush();
    }

    private static void BFS(int x, int y){
        ArrayList<Integer> set = new ArrayList<>();
        Queue<ArrayList<Integer>> queue = new LinkedList<>();

        int[] aroundX = {-1,0,1,0};
        int[] aroundY = {0,1,0,-1};

        set.add(x);
        set.add(y);
        queue.offer(set);
        visited[x][y] = 1;

        while(!queue.isEmpty()){
            ArrayList<Integer> cur = queue.poll();
            for(int i = 0; i<4;i++){
                int a = cur.get(0) + aroundX[i];
                int b = cur.get(1) + aroundY[i];
                if(a>-1 && b>-1 && arr[a][b] == 1 && visited[a][b] == 0){
                    set = new ArrayList<>();
                    set.add(a);
                    set.add(b);
                    queue.offer(set);
                    visited[a][b] = 1;
                }
            }
        }

    }
}
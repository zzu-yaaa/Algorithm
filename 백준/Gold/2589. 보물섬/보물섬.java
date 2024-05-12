import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        arr = new int[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                if(input.charAt(j) == 'W'){
                    arr[i][j] = 0;
                }
                else if (input.charAt(j) == 'L') {
                    arr[i][j] = 1;
                }
            }
        }

        int max = -1;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                visited = new int[n][m];
                if(arr[i][j] == 1){
                    max = Math.max(max,BFS(i,j));
                }
            }
        }

        bw.write(String.valueOf(max-1));
        bw.flush();
    }

    private static int BFS(int x, int y){
        ArrayList<Integer> set = new ArrayList<>();
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        //상하좌우
        int[] X = {-1,1,0,0};
        int[] Y = {0,0,-1,1};

        int hour = 1;
        set.add(x);
        set.add(y);
        set.add(hour);
        q.add(set);
        visited[x][y]=hour;

        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            for(int i=0; i<4;i++){
                int a = cur.get(0) + X[i];
                int b = cur.get(1) + Y[i];
                if(a>-1 && b>-1 && a<n && b<m &&
                        arr[a][b] == 1 && visited[a][b] == 0){
                    set = new ArrayList<>();
                    set.add(a);
                    set.add(b);
                    set.add(cur.get(2)+1);
                    q.offer(set);
                    visited[a][b] = cur.get(2)+1;
                }
            }
        }

        int max = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max = Math.max(max, visited[i][j]);
            }
        }

        return max;

    }
}

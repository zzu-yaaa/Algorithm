import java.io.*;
import java.util.*;

//2차원 틈마토
public class Main {

    static int m,n;
    static int[][] arr;
    static int[][] visited;
    static Queue<ArrayList<Integer>> q = new LinkedList<>();
    static ArrayList<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        m = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);

        arr = new int[n][m];
        for(int i = 0; i<n;i++){
            inputArr = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        visited = new int[n][m];
        for(int i = 0; i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1){
                    visited[i][j] = 0;
                    set = new ArrayList<>();
                    set.add(i);
                    set.add(j);
                    set.add(0);
                    q.offer(set);
                }
                else{
                    visited[i][j]=-1;
                }
            }
        }

        BFS();

        int result = findDay();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void BFS(){

        int[] aroundX = {-1,0,1,0};
        int[] aroundY = {0,1,0,-1};

        while (!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();

            for(int i=0;i<4;i++){
                int a = cur.get(0) + aroundX[i];
                int b = cur.get(1) + aroundY[i];
                int d = cur.get(2);

                //범위 밖
                if(a<0 || b<0 || a==n || b==m){
                    continue;
                }
                //노 틈마퉈
                if(arr[a][b] == -1){
                    continue;
                }
                //이미 방문
                if(visited[a][b] != -1){
                    continue;
                }

                set = new ArrayList<>();
                set.add(a);
                set.add(b);
                set.add(d+1);
                visited[a][b]=d+1;
                q.offer(set);
            }
        }

    }

    private static int findDay(){
        int result = -1;
        for(int i = 0; i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == -1 && arr[i][j] != -1){
                    return -1;
                }
                if(arr[i][j] != -1){
                    result = Math.max(result, visited[i][j]);
                }
            }
        }
        return result;
    }
}

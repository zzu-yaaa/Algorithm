import java.io.*;
import java.util.*;

public class Main{

    static int m,n,h;
    static int[][][] arr;
    static int[][][] visited;
    static ArrayList<Integer> set;
    static Queue<ArrayList<Integer>> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        m = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);
        h = Integer.parseInt(inputArr[2]);
        arr = new int[n][m][h];
        visited = new int[n][m][h];

        for(int i = 0; i<h;i++){
            for(int j = 0;j<n;j++){
                inputArr = br.readLine().split(" ");
                for(int k=0;k<m;k++){
                    arr[j][k][i] = Integer.parseInt(inputArr[k]);
                }
            }
        }

        for(int i = 0; i<h;i++){
            for(int j = 0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[j][k][i] == 1){
                        visited[j][k][i] = 0;
                        set = new ArrayList<>();
                        set.add(j);
                        set.add(k);
                        set.add(i);
                        set.add(0);
                        q.offer(set);
                    }
                    else{
                        visited[j][k][i] = -1;
                    }
                }
            }
        }

        BFS();

        String result = findDay();

        //bw.write(String.valueOf(result));
        bw.write(result);
        bw.flush();
    }

    private static void BFS(){
        int[] X = {0,0,0,0,-1,1};
        int[] Y = {0,0,-1,1,0,0};
        int[] Z = {-1,1,0,0,0,0};

        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            for(int i= 0;i<6;i++){
                int a = cur.get(0)+X[i];
                int b = cur.get(1)+Y[i];
                int c = cur.get(2)+Z[i];
                int d = cur.get(3);

                if(a<0 || b<0 || c<0 || a ==n ||b==m||c==h){
                    continue;
                }
                //no tomato
                if(arr[a][b][c] == -1){
                    continue;
                }
                //already visit
                if(visited[a][b][c] != -1){
                    continue;
                }

                set = new ArrayList<>();
                set.add(a);
                set.add(b);
                set.add(c);
                set.add(d+1);
                visited[a][b][c] = d+1;
                q.offer(set);
            }
        }

    }

    private static String findDay(){
        int result = -1;
        for(int i = 0; i<h;i++){
            for(int j = 0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(visited[j][k][i] == -1 && arr[j][k][i] != -1){
                        result = -1;
                        return String.valueOf(result);
                    }
                    if(arr[j][k][i] != -1){
                        result = Math.max(result, visited[j][k][i]);
                    }
                }
            }
        }
        return String.valueOf(result);
    }
}
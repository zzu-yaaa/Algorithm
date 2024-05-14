import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i = 0;i<m;i++){
            inputArr = br.readLine().split(" ");
            int type = Integer.parseInt(inputArr[0]);
            int a = Integer.parseInt(inputArr[1]);
            int b = Integer.parseInt(inputArr[2]);
            if(type == 0){
                union(a,b);
            }
            else if(type == 1){
                bw.write(contain(a,b)+"\n");
            }
        }

        bw.flush();
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[y] = x;
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static String contain(int a, int b){
        if(find(a) == find(b)){
            return "yes";
        }
        else{
            return "no";
        }
    }
}

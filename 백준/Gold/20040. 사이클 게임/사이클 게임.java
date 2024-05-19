import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i=0;i<m;i++){
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);

            if(find(a)==find(b)) {
                result = i+1;
                break;
            }else {
                union(a,b);
            }
        }

        bw.write(String.valueOf(result));
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
}

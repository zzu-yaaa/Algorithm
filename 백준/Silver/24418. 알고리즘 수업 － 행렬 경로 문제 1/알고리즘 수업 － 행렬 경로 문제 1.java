import java.io.*;

public class Main{
    static int n;
    static int[][] M;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        M = new int[n][n];
        for(int i = 0; i<n;i++){
            String[] inputArr = br.readLine().split(" ");
            for(int j = 0; j<n;j++){
                M[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        func(n,n);

        bw.write(String.valueOf(cnt)+" "+String.valueOf(n*n));
        bw.flush();
    }

    private static void func(int i, int j){
        if(i == 0 || j == 0){
            cnt += 1;
            return;
        }
        func(i-1,j);
        func(i,j-1);
    }
}
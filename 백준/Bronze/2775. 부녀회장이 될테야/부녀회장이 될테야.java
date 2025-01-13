import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int a=0; a<t ; a++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k+1][n];
            for(int i=0 ; i<n; i++){
                arr[0][i] = i+1;
            }
            for(int i=0; i<=k; i++){
                arr[i][0] = 1;
            }

            for(int i=0;i<=k;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j] == 0){
                        arr[i][j] = arr[i-1][j] + arr[i][j-1];
                    }
                }
            }

            bw.write(String.valueOf(arr[k][n-1])+"\n");
        }

        bw.flush();
    }
}

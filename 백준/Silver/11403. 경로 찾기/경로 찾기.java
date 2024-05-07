import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] inputArr;
        arr = new int[n+1][n+1];
        for(int i =0 ;i<n;i++){
            inputArr = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for(int i =0 ;i<n;i++){
            for(int j=0;j<n;j++){
                bw.write(String.valueOf(arr[i][j])+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}

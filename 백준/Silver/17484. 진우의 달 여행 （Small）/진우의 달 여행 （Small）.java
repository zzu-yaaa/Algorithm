import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        int[][] board = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for(int i = 0;i<N;i++){
            inputArr = br.readLine().split(" ");
            for(int j = 0; j<M;j++){
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        for(int j = 0; j < M; j++) {
            dp[0][j][0] = board[0][j];
            dp[0][j][1] = board[0][j];
            dp[0][j][2] = board[0][j];
        }

        for(int i=1;i<N;i++){
            for (int j=0;j<M;j++){
                if(j == 0){
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+board[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + board[i][j];
                    dp[i][j][2] = 1000;
                }
                else if(j == M-1){
                    dp[i][j][0] = 1000;
                    dp[i][j][1] = dp[i-1][j][2] + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j-1][1]) + board[i][j];
                }
                else{
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+board[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0],dp[i-1][j][2])+board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j-1][1])+board[i][j];
                }
            }
        }

        int min = 1000;
        for(int i =0;i<M;i++){
            for(int j = 0;j<3;j++){
                if(dp[N-1][i][j] < min){
                    min = dp[N-1][i][j];
                }
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }
}
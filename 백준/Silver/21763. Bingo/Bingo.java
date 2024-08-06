import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        if(n == 1 && k == 0){
            bw.write("YES\n");
            bw.write(".");
        }
        else if(n == 2 && k >= 2){
            bw.write("NO\n");
        }
        else if ( (n - 1) * n  < k ) {
            bw.write("NO\n");
        }
        else {
            bw.write("YES\n");

            //배열을 .으로 채운다 (. = 0)
            int[][] out = new int[n][n];
            for (int[] temp : out) {
                Arrays.fill(temp, 0);
            }

            //#의 개수
            int cnt = 0;

            //대각선 빙고가 아닌 곳 부터 #으로
            for(int i=0; i<n && cnt < k; i++){
                for(int j=0; j<n && cnt < k; j++){
                    if(i!=j && i+j != n-1){
                        out[i][j] = 1;
                        cnt += 1;
                    }
                }
            }

            //오른쪽 대각선(\)의 양 끝점을 #으로 바꾼다
            if(cnt < k){
                out[0][0] = 1;
                cnt +=1;
            }

            if(cnt < k){
                out[n-1][n-1] = 1;
                cnt += 1;
            }

            //왼쪽 대각선(/)의 양 끝점 및 중심점을 제외하고 #으로 바꾼다
            for(int i=1; i<n-1 && cnt<k; i++){
                for(int j=1; j<n-i && cnt<k ; j++){
                    if(i+j == n-1 && i != j){
                        out[i][j] = 1;
                        cnt += 1;
                    }
                }
            }


            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(out[i][j] == 1){
                        bw.write("#");
                    }
                    else{
                        bw.write(".");
                    }
                }
                bw.write("\n");
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}

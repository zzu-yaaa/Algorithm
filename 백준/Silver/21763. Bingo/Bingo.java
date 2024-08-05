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
        else{
            if (((n - 1) * n) - 1 < k) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
                int[][] out = new int[n][n];
                for (int[] temp : out) {
                    Arrays.fill(temp, 0);
                }

                int cnt = 0;
                int full = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if(i==n-1 && j==0) continue;
                        if (cnt >= k) {
                            full = 1;
                            break;
                        }
                        out[i][(i + j) % n] = 1;
                        cnt += 1;
                    }
                    if(full == 1){
                        break;
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
        }

        br.close();
        bw.close();
    }
}

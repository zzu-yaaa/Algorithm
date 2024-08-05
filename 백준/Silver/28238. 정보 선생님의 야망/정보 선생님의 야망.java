import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int in[][] = new int[n+1][5];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                in[i][j] = Integer.parseInt(s[j]);
            }
        }

        int cnt = 0;
        int max = -1;
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (in[k][i] == 1 && in[k][j] == 1) {
                        cnt += 1;
                    }
                }
                if (max < cnt) {
                    max = cnt;
                    result = new int[5];
                    result[i] = 1;
                    result[j] = 1;
                }
                cnt = 0;
            }
        }

        bw.write(String.valueOf(max + "\n"));
        for (int i : result) {
            bw.write(String.valueOf(i)+" ");
        }

        br.close();
        bw.close();
    }
}

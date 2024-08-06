import java.io.*;

public class Main {

    static int n;
    static int m;
    static String[][] in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        in = new String[n][m];

        for(int i = 0; i<n ; i++) {
            String str = br.readLine();
            for(int j = 0; j<m ; j++) {
                in[i][j] = str.charAt(j)+"";
            }
        }

        int result = 0;
        for(int i = 0; i<n ; i++) {
            for(int j = 0; j<m ; j++) {
                if(i == 0 && in[i][j].equals("U")){
                    result += find(1, i, j);
                }
                else if(i == n-1 && in[i][j].equals("D")){
                    result += find(1, i, j);
                }
                else if(j == 0 && in[i][j].equals("L")){
                    result += find(1, i, j);
                }
                else if(j == m-1 && in[i][j].equals("R")){
                    result += find(1, i, j);
                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();

        br.close();
        bw.close();
    }

    private static Integer find(int cnt, int i, int j) {
        if(i-1 >= 0 && in[i-1][j].equals("D")){
            cnt = find(cnt+1, i-1, j);
        }
        if(i+1 < n && in[i+1][j].equals("U")){
            cnt = find(cnt+1, i+1, j);
        }
        if(j-1 >= 0 && in[i][j-1].equals("R")){
            cnt = find(cnt+1, i, j-1);
        }
        if(j+1 < m && in[i][j+1].equals("L")){
            cnt = find(cnt + 1, i, j+1);
        }
        return cnt;
    }

}

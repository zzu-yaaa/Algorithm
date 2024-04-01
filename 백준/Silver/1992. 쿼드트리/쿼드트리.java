import java.io.*;

public class Main{
    static int N;
    static char[][] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        String input;
        for(int i = 0;i<N;i++){
            input = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = input.charAt(j);
            }
        }

        compress(0,0,N);

        bw.flush();
    }

    private static void compress(int x, int y, int n) throws IOException {
        //base condition
        if(n==1) {
            bw.write(arr[x][y]);
            return;
        }

        boolean allSame = true;
        for(int i = x; i < x+n; i++){
            for(int j = y ; j< y+n;j++){
                if(arr[i][j] != arr[x][y]){
                    allSame = false;
                }
            }
        }

        if(allSame){
            bw.write(arr[x][y]);
            return;
        }

        bw.write("(");
        compress(x, y, n / 2);
        compress(x, y + n/2, n / 2);
        compress(x+ n/2, y, n / 2);
        compress(x+ n/2, y + n/2, n / 2);
        bw.write(")");
    }
}
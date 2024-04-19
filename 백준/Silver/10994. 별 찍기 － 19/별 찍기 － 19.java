import java.io.*;

public class Main{
    static int[][] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        result = new int[4*(N-1)+1][4*(N-1)+1];

        func(N, 0);

        for(int i = 0; i<4*(N-1)+1;i++){
            for(int j = 0; j<4*(N-1)+1;j++){
                if(result[i][j] == 1){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();

    }

    private static void func(int n, int cnt){

        if(n == 1){
            result[cnt*2][cnt*2] = 1;
            return;
        }

        for(int i = cnt*2; i< (cnt*2) + 4*(n-1)+1;i++){
            for(int j = cnt*2; j< (cnt*2)+4*(n-1)+1;j++){
                if(i==cnt*2 || i == cnt*2 + 4*(n-1)){
                    result[i][j] = 1;
                }
                if(j==cnt*2 || j == cnt*2 + 4*(n-1)){
                    result[i][j] = 1;
                }
            }
        }

        func(n-1, cnt+1);

    }
}
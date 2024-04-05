import java.io.*;

public class Main{
    
    static int[] num = new int[1001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        num[0] = 1;
        num[1] = 1;
        for(int i = 0; i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int result = func(N);
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
    }

    private static int func(int n){
        int cnt = 0;

        for(int i = 0; i<=n;i++){
            if((n-i)%2==0){
                if(num[(n - i) / 2] != 0){
                    cnt += num[(n - i) / 2];
                }
                else{
                    num[(n - i) / 2] = func((n - i) / 2);
                    cnt += num[(n - i) / 2];
                }
            }
        }
        return cnt;
    }
}
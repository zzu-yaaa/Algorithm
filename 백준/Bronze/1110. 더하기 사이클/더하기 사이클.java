import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cur = n;
        int cnt = 0;

        do{
            int a = cur/10;
            int b = cur%10;
            cur = b*10 + (a+b)%10;
            cnt += 1;
        } while(n != cur);


        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}

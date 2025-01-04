import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int n1 = n/10;
        int n2 = n%10;

        int a = n1;
        int b = n2;
        int cnt = 1;

        int temp = b*10 + (a+b) % 10;
        a = b;
        b = temp % 10;

        while(!(a==n1 && b==n2)){
            temp = b*10 + (a+b) % 10;
            a = b;
            b = temp % 10;
            cnt += 1;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}

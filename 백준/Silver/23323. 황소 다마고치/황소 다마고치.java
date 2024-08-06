import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long m = Long.parseLong(s[1]);

            long cnt = 0;
            while(n > 0){
                n = n/2;
                cnt += 1;
            }
            cnt += m;

            bw.write(String.valueOf(cnt) + "\n");

        }

        bw.flush();

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        long k = Long.parseLong(in[0]);
        long p = Long.parseLong(in[1]);
        long n = Long.parseLong(in[2]);

        for(int i=0; i<n; i++){
            k *= p;
            k %= 1000000007;
        }

        bw.write(String.valueOf(k%1000000007));
        bw.flush();
    }
}
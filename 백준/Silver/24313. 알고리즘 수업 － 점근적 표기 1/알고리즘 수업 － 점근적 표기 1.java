import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean result = false;

        // c가 a보다 큰 경우
        if (c > a) {
            if (b <= (c - a) * n) {
                result = true;
            }
        }
        else if (c == a) {
            if (b <= 0) {
                result = true;
            }
        }

        if(result){
            bw.write("1");
        }
        else{
            bw.write("0");
        }

        bw.flush();

    }
}

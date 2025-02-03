import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int[] sum = new int[n+1];
        sum[0] = 0;

        for(int i=0;i<n;i++){
            sum[i+1] += sum[i] + Integer.parseInt(in[i]);
        }

        for(int i=0;i<k;i++){
            String[] between = br.readLine().split(" ");
            int left = Integer.parseInt(between[0]);
            int right = Integer.parseInt(between[1]);

            double temp = sum[right] - sum[left-1];
            bw.write(String.format("%.2f", temp/(right-left+1))+"\n");
        }
        bw.flush();

    }
}

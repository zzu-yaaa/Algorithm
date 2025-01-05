import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        int v = Integer.parseInt(in[2]);

        double n = (v-a) / (double)(a-b);

        double answer = Math.ceil(n) + 1;

        bw.write(String.valueOf((int)answer));
        bw.flush();
    }
}

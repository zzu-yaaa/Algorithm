import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int temp = 1;
        while(n >= Math.pow(temp+1,2)){
            temp += 1;
        }

        bw.write(temp + "\n");

        bw.flush();
        br.close();
        bw.close();

    }
}

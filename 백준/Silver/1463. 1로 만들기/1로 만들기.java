import java.io.*;

public class Main{
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr[1] = 0;

        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }

        bw.write(String.valueOf(arr[N]));
        bw.flush();
    }
}
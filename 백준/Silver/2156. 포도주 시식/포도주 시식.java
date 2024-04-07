import java.io.*;

public class Main{
    static int[] arr = new int[10001];

    static int[] result = new int[10001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        result[1] = arr[1];
        if (n >= 2) result[2] = arr[1] + arr[2];

        if (n >= 3) result[3] = Math.max(arr[1] + arr[3], Math.max(arr[2] + arr[3], result[2]));

        for (int i = 4; i <= n; i++) {
            result[i] = Math.max(result[i - 1], Math.max(result[i -  2] + arr[i], result[i - 3] + arr[i - 1] + arr[i]));
        }

        bw.write(String.valueOf(result[n]));
        bw.flush();
    }
}
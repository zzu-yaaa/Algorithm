import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        for(int i = 1; i<=num;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[301];
        result[1] = arr[1];
        result[2] = arr[1] + arr[2];
        result[3] = Math.max(arr[1],arr[2]) + arr[3];
        for(int i=4;i<=num;i++){
            result[i] = Math.max(result[i-3]+arr[i-1], result[i-2]) + arr[i];
        }

        bw.write(String.valueOf(result[num]));
        bw.flush();
    }
}
import java.io.*;

public class Main{
    static long[] arr = new long[36];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr[0]=1;
        long result = t(n);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static long t(int n){
        long result = 0;
        if(n == 0){
            return arr[0];
        }

        long num1 = 0;
        long num2 = 0;
        for(int i = 0; i<=n-1;i++){
            if(arr[i]!=0){
                num1 = arr[i];
            }
            else{
                arr[i] = t(i);
                num1 = arr[i];
            }

            if(arr[n-1-i]!=0){
                num2 = arr[n-1-i];
            }
            else{
                arr[n-1-i] = t(n-1-i);
                num2 = arr[n-1-i];
            }
            result += num1 * num2;
        }
        return result;
    }
}
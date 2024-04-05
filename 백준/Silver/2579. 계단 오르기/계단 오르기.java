import java.io.*;

public class Main{
    static int[] arr = new int[301];

    static int[] result = new int[301];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for(int i = 1; i<=num;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        result[1] = arr[1];
        result[2] = arr[1] + arr[2];
        result[3] = Math.max(arr[1],arr[2]) + arr[3];
        func(num);
        
        bw.write(String.valueOf(result[num]));
        bw.flush();
    }

    private static int func(int n){
        if(n == 1 || n==2 || n==3){
            return result[n];
        }

        if(result[n] != 0){
            return result[n];
        }

        return result[n] = Math.max(func(n-3)+arr[n-1],func(n-2))+arr[n];
    }
}
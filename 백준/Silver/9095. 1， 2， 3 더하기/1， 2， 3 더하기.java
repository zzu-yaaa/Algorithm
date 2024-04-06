import java.io.*;

public class Main{
    static int[] arr = new int[12];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        int result = 0;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++){
            int n = Integer.parseInt(br.readLine());
            result = func(n);
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
    }

    private static int func(int n){

        if(arr[n] != 0){
            return arr[n];
        }

        return arr[n] = func(n-1)+func(n-2)+func(n-3);
    }
}
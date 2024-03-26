import java.io.*;
import java.util.*;

public class Main{
    static int[] arr = new int[20];
    static int N,S;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        S = Integer.parseInt(inputArr[1]);
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subset(0,0);
        if(S==0) cnt -= 1;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void subset(int idx, int sum){
        if(idx == N){
            if(sum==S){
                cnt += 1;
            }
            return;
        }
        subset(idx+1, sum);
        subset(idx+1, sum+arr[idx]);
    }

}
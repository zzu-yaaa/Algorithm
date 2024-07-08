import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);

        int[] arr = new int[n+1];
        inputArr = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int result = Integer.MAX_VALUE;
        int temp = 0;

        while(start <= end && end <= n){
            if(cnt < k){
                if(arr[end]==1){
                    cnt+=1;
                }
                end += 1;
            }
            else{
                temp = end - start;
                if(arr[start] == 1){
                    cnt -= 1;
                }
                start += 1;
                result = Math.min(result, temp);
            }
        }

        if (result == Integer.MAX_VALUE){
            result = -1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close(); bw.close();
    }
}


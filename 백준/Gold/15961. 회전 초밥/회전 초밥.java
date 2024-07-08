import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] input = new int[n+1];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[d+1];
        int max = -1;
        int unique = 0;

        for(int i = 0;i<k;i++){
            if(cnt[input[i]] == 0){
                unique += 1;
            }
            cnt[input[i]] += 1;
        }

        for(int i=1;i<n;i++){
            int front = input[i-1];
            cnt[front] -= 1;
            if(cnt[front] == 0){
                unique -= 1;
            }


            int back = input[(i+k-1)%n];
            if(cnt[back]==0){
                unique += 1;
            }
            cnt[back] += 1;

            if(cnt[c]==0){
                max = Math.max(max, unique+1);
            }
            else{
                max = Math.max(max, unique);
            }

        }

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();

    }
}

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer("<");

        String input = br.readLine();
        String[] temp = input.split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        int[] num = new int[5001];
        int[] result = new int[5001];
        int numIdx = 1;
        int reIdx = 0;

        for(int i=1;i<=N;i++){
            num[i] = i;
        }

        int cnt = 0;
        while(reIdx < N){

            if(numIdx > N){
                numIdx = 1;
            }

            if(num[numIdx] != 0){
                cnt += 1;
            }

            if (cnt == K){
                cnt = 0;
                result[reIdx++] = num[numIdx];
                num[numIdx] = 0;
            }
            numIdx += 1;
        }

        for(int i=0;i<N-1;i++){
            sb.append(String.valueOf(result[i])).append(", ");
        }
        sb.append(String.valueOf(result[N-1])).append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}
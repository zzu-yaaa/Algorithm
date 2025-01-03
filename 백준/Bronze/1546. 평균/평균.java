import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] score = new int[n+1];

        int max = -1;
        int tot = 0;
        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(str[i]);
            if(max < score[i]){
                max = score[i];
            }
            tot += score[i];
        }

        double ave = tot/(double)n;
        double answer = ave/(double)max*100;

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] height = new int[9];
        int total = 0;

        for(int i=0; i<9 ; i++){
            height[i] = Integer.parseInt(br.readLine());
            total += height[i];
        }

        Arrays.sort(height);

        int flag = 0;
        for(int i=8 ; i>=0 ; i--){
            for(int j=i-1 ; j>=0 ; j--){
                if(flag == 0 && height[i]+height[j] == total - 100){
                    height[i] = 0;
                    height[j] = 0;
                    flag = 1;
                }
            }
        }

        for(int i=0; i<9 ; i++){
            if(height[i] != 0){
                bw.write(String.valueOf(height[i])+"\n");
            }
        }

        bw.flush();

    }
}

import java.io.*;

public class Main{
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int B = Integer.parseInt(arr[2]);
        int[][] arr2 = new int[N][M];

        int temp = 0;
        int time = 0;
        int minTime = 1000000000;
        int height = 0;
        int rest = 0;
        int min = 500, max = -1;

        for(int i=0;i<N;i++){
            arr = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                temp = Integer.parseInt(arr[j]);
                if(temp < min){
                    min = temp;
                }
                if(temp > max){
                    max = temp;
                }
                arr2[i][j] = temp;
            }
        }

        for(int i = max; i>=min;i--){
            time = 0;
            rest = B;
            for(int j = 0; j<N;j++){
                for(int k = 0; k<M;k++){
                    if(arr2[j][k]<i){
                        time += i-arr2[j][k];
                        rest -= i-arr2[j][k];
                    }
                    else if(arr2[j][k]>i){
                        time += (arr2[j][k]-i)*2;
                        rest += arr2[j][k]-i;
                    }
                }
            }

            if(rest >= 0 && time<minTime){
                minTime = time;
                height = i;
            }
        }

        bw.write(String.valueOf(minTime)+" "+ String.valueOf(height));
        bw.flush();
    }
}
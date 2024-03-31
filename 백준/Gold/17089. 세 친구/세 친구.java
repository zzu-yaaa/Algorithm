import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);

        Boolean[][] friend = new Boolean[N+1][N+1];
        int[] cnt = new int[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                friend[i][j] = false;
            }
        }

        int temp1, temp2;
        for(int i = 0 ; i<M;i++){
            inputArr = br.readLine().split(" ");
            temp1 = Integer.parseInt(inputArr[0]);
            temp2 = Integer.parseInt(inputArr[1]);
            friend[temp1][temp2] = true;
            friend[temp2][temp1] = true;

            cnt[temp1]+=1;
            cnt[temp2]+=1;
        }



        int result = -1;
        int min = 100000000;
        for(int i = 1;i<N+1;i++){
            for(int j = i+1;j<N+1;j++){
                if(!friend[i][j]) continue;
                for(int k = j+1; k < N+1; k++){
                    if(!friend[k][i] || !friend[k][j]) continue;
                    result = cnt[i] + cnt[j] + cnt[k] - 6;
                    if(min > result){
                        min = result;
                    }
                }
            }

        }

        if(min == 100000000){
            bw.write("-1");
        }
        else{
            bw.write(String.valueOf(min));
        }

        bw.flush();

    }
}
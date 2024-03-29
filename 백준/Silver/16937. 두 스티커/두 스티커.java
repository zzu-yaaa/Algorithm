import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int N = Integer.parseInt(br.readLine());
        int[][] sticker = new int[N][2];
        for(int i = 0; i< N;i++){
            input = br.readLine().split(" ");
            sticker[i][0]=Integer.parseInt(input[0]);
            sticker[i][1]= Integer.parseInt(input[1]);
        }

        int result = 0; 
        int max = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(sticker[i][0] + sticker[j][0] <= H && Math.max(sticker[i][1], sticker[j][1]) <= W ||
                        sticker[i][0] + sticker[j][0] <= W && Math.max(sticker[i][1], sticker[j][1]) <= H) {
                    result = sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1];
                }
                else if(sticker[i][0] + sticker[j][1] <= H && Math.max(sticker[i][1], sticker[j][0]) <= W ||
                        sticker[i][0] + sticker[j][1] <= W && Math.max(sticker[i][1], sticker[j][0]) <= H) {
                    result = sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1];
                }
                else if(sticker[i][1] + sticker[j][0] <= H && Math.max(sticker[i][0], sticker[j][1]) <= W ||
                        sticker[i][1] + sticker[j][0] <= W && Math.max(sticker[i][0], sticker[j][1]) <= H) {
                    result = sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1];
                }
                else if(sticker[i][1] + sticker[j][1] <= H && Math.max(sticker[i][0], sticker[j][0]) <= W ||
                        sticker[i][1] + sticker[j][1] <= W && Math.max(sticker[i][0], sticker[j][0]) <= H) {
                    result = sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1];
                }
                if(max < result) max = result;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        Long N = Long.parseLong(inputArr[0]);
        Long M = Long.parseLong(inputArr[1]);
        Long L = Long.parseLong(inputArr[2]);

        ArrayList<Long> point = new ArrayList<>();
        for(int i = 0; i<M;i++){
            point.add(Long.parseLong(br.readLine()));
        }
        point.add(L);

        for(int i=0; i<N;i++){
            long time = Long.parseLong(br.readLine());
            long low = 0;
            long high = L;
            long mid = 0;
            long answer = low;
            int cnt = 0;
            while(low <= high){
                mid = (low+high)/2;
                cnt = 0;
                long selected = 0;
                for(int j = 0;j<=M;j++){
                    if(point.get(j) - selected >= mid){
                        cnt += 1;
                        selected = point.get(j);
                    }
                }

                if(cnt > time){
                    low = mid +1;
                    answer = mid;
                }
                else{
                    high = mid -1;
                }

            }
            bw.write(String.valueOf(answer) + "\n");
        }

        bw.flush();
    }
}
import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Long> amount = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);
        for(int i = 0; i<N;i++){
            amount.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(amount);

        long low = 1;
        long high = amount.get(N-1);
        long mid = 0;
        long cnt = 0;
        long answer = low;
        while(low<=high){
            mid = (low+high)/2;
            cnt = func(mid);
            if(cnt >= K){
                low = mid + 1;
                answer = mid;
            }
            else{
                high = mid -1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int func(long mid){
        int cnt = 0;
        for (Long l : amount) {
            cnt += (int) (l / mid);
        }

        return cnt;
    }
}
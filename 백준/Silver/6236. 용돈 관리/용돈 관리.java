import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static ArrayList<Long> money = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        long max = 0;
        for(int i = 0; i<N;i++){
            money.add(Long.parseLong(br.readLine()));
            max = Math.max(max,money.get(i));
        }
        
        long low = max;
        long high = max * N;
        long mid = 0;
        long cnt = 0;
        long answer = low;
        while(low <= high){
            mid = (low+high)/2;
            cnt = func(mid);
            if(cnt > M){
                low = mid + 1;
            }
            else{
                high = mid -1;
                answer = mid;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int func(long x){
        int cnt = 1;
        long temp = x;
        for(int i = 0; i<N;i++){
            if(money.get(i) <= temp){
                temp = temp - money.get(i);
            }
            else{
                cnt += 1;
                temp = x;
                temp = temp - money.get(i);
            }
        }
        return cnt;
    }
}
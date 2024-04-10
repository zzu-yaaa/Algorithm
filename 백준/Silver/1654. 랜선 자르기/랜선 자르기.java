import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        long K = Long.parseLong(inputArr[0]);
        long N = Long.parseLong(inputArr[1]);

        ArrayList<Long> lan = new ArrayList<>();
        for(int i = 0;i<K;i++){
            lan.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(lan);

        long low  = 1;
        long high = lan.get(lan.size()-1);
        long mid = 0;
        long result = 0;
        long answer = low;
        while(low <= high){
            mid = (low+high)/2;
            result = 0;
            for (int i = 0;i<K;i++){
                result += lan.get(i)/mid;
            }
            if(result >= N){
                low = mid+1;
                answer = mid;
            }
            else{
                high = mid-1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
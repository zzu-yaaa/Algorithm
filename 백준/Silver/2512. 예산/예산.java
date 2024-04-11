import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        ArrayList<Long> budget = new ArrayList<>();
        for(int i = 0; i<N;i++){
            budget.add(Long.parseLong(inputArr[i]));
        }
        int M = Integer.parseInt(br.readLine());
        Collections.sort(budget);

        long low = 1;
        long high = budget.get(budget.size()-1);
        long mid = 0;
        long sum = 0;
        long answer = low;
        while(low <= high){
            mid = (low+high) / 2;
            sum = 0;
            for(int i = 0; i<N;i++){
                if(budget.get(i) <= mid){
                    sum += budget.get(i);
                }
                else{
                    sum += mid;
                }
            }
            if(sum <= M){
                low = mid+1;
                answer = mid;
            }
            else{
                high = mid - 1;
            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
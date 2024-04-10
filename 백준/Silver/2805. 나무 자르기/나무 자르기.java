import java.io.*;
import java.util.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        long N = Long.parseLong(inputArr[0]);
        long M = Long.parseLong(inputArr[1]);

        inputArr = br.readLine().split(" ");
        ArrayList<Long> tree = new ArrayList<>();
        for(int i = 0; i<N; i++){
            tree.add(Long.parseLong(inputArr[i]));
        }
        Collections.sort(tree);

        long low = 0;
        long high = tree.get(tree.size()-1);
        long mid = 0;
        long result = 0;
        long answer = low;
        while(low <= high){
            mid = (low + high)/2;
            result = 0;
            for(int i = 0;i<N;i++){
                result += Math.max(0,tree.get(i) - mid);
            }
            if(result >= M){
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

}
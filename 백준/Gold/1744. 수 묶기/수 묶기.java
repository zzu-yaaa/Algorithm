import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();


        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 1){
                result += 1;
            }
            else if(temp > 0){
                positive.add(temp);
            }
            else{
                negative.add(temp);
            }
        }

        while(positive.size()>1){
            result += positive.poll() * positive.poll();
        }
        if(!positive.isEmpty()){
            result += positive.poll();
        }

        while(negative.size()>1){
            result += negative.poll() * negative.poll();
        }
        if(!negative.isEmpty()){
            result += negative.poll();
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

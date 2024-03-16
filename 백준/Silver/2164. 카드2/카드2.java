import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=num;i++){
            queue.offer(i);
        }
        
        int temp = 0;
        while(queue.size() > 1){
            queue.poll();
            temp = queue.poll();
            queue.offer(temp);
        }
        
        bw.write(String.valueOf(queue.peek()));
        bw.flush();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n;i++){
            q.offer(i+1);
        }

        while(q.size()>1){
            bw.write(String.valueOf(q.poll())+" ");
            q.offer(q.poll());
        }
        bw.write(String.valueOf(q.poll())+" ");

        bw.flush();

    }
}

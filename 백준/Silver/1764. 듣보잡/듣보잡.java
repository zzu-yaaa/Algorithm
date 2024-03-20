import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] temp = input.split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        HashMap<String, Integer> name = new HashMap<>();
        String temp2;
        PriorityQueue<String> result = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            temp2 = br.readLine();
            name.put(temp2,1);
        }
        for(int i=0;i<M;i++){
            temp2 = br.readLine();
            if(name.containsKey(temp2)){
                result.offer(temp2);
            }
        }

        bw.write(result.size() +"\n");
        while(!result.isEmpty()){
            bw.write(result.poll()+"\n");
        }
        bw.flush();

    }
}
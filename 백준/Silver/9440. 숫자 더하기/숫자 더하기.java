import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        while(cnt > 0){
            PriorityQueue<Integer> input = new PriorityQueue<>();
            int zero = 0;
            while(st.hasMoreTokens()){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0){
                    zero += 1;
                }
                else{
                    input.offer(temp);
                }
            }

            int[] num = new int[cnt+1];
            Arrays.fill(num, -1);
            int idx = 2;
            for(int i=0;i<zero;i++){
                num[idx] = 0;
                idx += 1;
            }

            for(int i=0;i<cnt;i++){
                if(num[i] == 0){
                    continue;
                }
                if(!input.isEmpty()){
                    num[i] = input.poll();
                }
            }

            int result = 0;
            if(cnt%2==0){
                for(int i=0;i<cnt;i+=2){
                    result = (result*10) + num[i]+num[i+1];
                }
            }
            else{
                for(int i=0;i<cnt;i++){
                    if(i==0){
                        result += num[i];
                    }
                    else{
                        result = (result*10) + num[i]+num[i+1];
                        i += 1;
                    }
                }
            }

            bw.write(String.valueOf(result + "\n"));
            st = new StringTokenizer(br.readLine(), " ");
            cnt = Integer.parseInt(st.nextToken());

        }

        bw.flush();
    }
}

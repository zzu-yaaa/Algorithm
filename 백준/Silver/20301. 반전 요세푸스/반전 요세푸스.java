import java.io.*;
import java.util.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] temp = input.split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int M = Integer.parseInt(temp[2]);

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0;i<N;i++){
            deque.offerLast(i+1);
        }

        int cntM = 0;
        int cntK = 1;
        int addFront = 0; //0이면 back에 추가, 1이면 front에 추가
        while(deque.size() > 0){
            if(cntM == M){
                if(addFront == 0){
                    addFront = 1;
                }
                else{
                    addFront = 0;
                }
                cntM = 0;
            }

            if(addFront == 0 && cntK<K){
                deque.offerLast(deque.pollFirst());
                cntK += 1;
            }
            else if(addFront == 0 && cntK==K){
                bw.write(String.valueOf(deque.pollFirst())+"\n");
                cntK = 1;
                cntM += 1;

            }
            else if(addFront == 1 && cntK < K){
                deque.offerFirst(deque.pollLast());
                cntK += 1;
            }
            else if(addFront == 1 && cntK==K){
                bw.write(String.valueOf(deque.pollLast())+"\n");
                cntK = 1;
                cntM += 1;
            }
        }

        bw.flush();
    }
}
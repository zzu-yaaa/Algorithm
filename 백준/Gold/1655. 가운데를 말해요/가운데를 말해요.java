import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()){
                maxHeap.offer(x);
                if(minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }
            else{
                minHeap.offer(x);

                if(maxHeap.peek() > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }
            bw.write(String.valueOf(maxHeap.peek())+"\n");
        }


        bw.flush();
    }
}
import java.io.*;

public class Main{
    
    static int[] heap = new int[100001];
    static int heapIdx = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int x;

        for(int i=1;i<=N;i++){
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                bw.write(String.valueOf(delete())+"\n");
            }
            else{
                insert(x);
            }
        }

        bw.flush();
    }

    private static void insert(int x){
        heap[++heapIdx] = x;
        int i = heapIdx;
        int temp = 0;
        while(i > 1){
            if(heap[i] > heap[i/2]){
                temp = heap[i];
                heap[i] = heap[i/2];
                heap[i/2] = temp;
                i = i/2;
            }
            else{
                break;
            }
        }
    }

    private static int delete(){

        if(heapIdx <= 0){
            return 0;
        }

        int result = heap[1];
        heap[1] = heap[heapIdx--];

        int i = 1;
        int temp = 0;
        int left = 0;
        int right = 0;
        int child = 0;
        while(i *2 <= heapIdx){
            left = i*2;
            right = i*2+1;
            if (right <= heapIdx && heap[left] < heap[right]){
                child = right;
            }
            else{
                child = left;
            }

            if(heap[i] >= heap[child]){
                break;
            }

            temp = heap[i];
            heap[i] = heap[child];
            heap[child] = temp;
            i = child;

        }

        return result;
    }
    
}
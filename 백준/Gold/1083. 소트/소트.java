import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[N];
        int S = Integer.parseInt(br.readLine());

        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        int idx = 0;
        int max = -1;
        while (S > 0 && idx < N) {
            int maxIdx = idx;
            for (int i = idx + 1; i < N && i <= idx + S; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                    max = arr[maxIdx];

                }
            }

            if (maxIdx == idx) {
                idx++;
                continue;
            }

            for (int i = maxIdx; i > idx; i--) {
                arr[i] = arr[i - 1];
                S -= 1;
            }
            arr[idx] = max;
            idx++;
        }


        for(int i = 0;i<N;i++){
            bw.write(String.valueOf(arr[i])+" ");
        }
        bw.flush();
    }
}
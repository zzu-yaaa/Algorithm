import java.io.*;

public class Main{
    static int K;
    static int cnt = 0;
    static int answer = -1;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        K = Integer.parseInt(inputArr[1]);

        inputArr = br.readLine().split(" ");
        int[] arr = new int[N+1];
        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        mergeSort(arr, 0, N-1);

        bw.write(String.valueOf(answer));
        bw.flush();

    }

    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;  // 중간 지점 계산
            mergeSort(A, p, q);   // 전반부 정렬
            mergeSort(A, q + 1, r); // 후반부 정렬
            merge(A, p, q, r);    // 병합
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int[] tmp = new int[r - p + 1]; // 병합 결과를 임시로 저장할 배열

        int t = 0; // tmp 배열의 인덱스

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 남은 원소 처리
        while (i <= q) {
            tmp[t++] = A[i++];
        }
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        // tmp 배열의 내용을 A 배열의 p부터 r까지 복사
        i = p;
        t = 0;
        while (i <= r) {
            A[i++] = tmp[t++];
            cnt += 1;
            if(cnt == K){
                answer = A[i-1];
            }
        }
    }
}
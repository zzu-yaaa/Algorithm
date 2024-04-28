import java.io.*;

public class Main{
    static int[] cnt = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] inputArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        countPaper(0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(cnt[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void countPaper(int startX, int startY, int size) {
        if (isAllSame(startX, startY, size)) {
            int value = arr[startX][startY];
            if (value == -1) cnt[0]++;
            else if (value == 0) cnt[1]++;
            else if (value == 1) cnt[2]++;
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(startX + i * newSize, startY + j * newSize, newSize);
            }
        }
    }

    private static boolean isAllSame(int startX, int startY, int size) {
        int value = arr[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
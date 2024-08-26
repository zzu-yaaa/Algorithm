import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String[] str = br.readLine().split(" ");
        long x = Long.parseLong(str[0]);
        long y = Long.parseLong(str[1]);
        long w = Long.parseLong(str[2]);
        long s = Long.parseLong(str[3]);

        // 직선
        long a = (x + y) * w;

        // 대각선만 , 안되면 최대값
        long b = (x % 2 == y % 2) ? Math.max(x, y) * s : (Math.max(x, y) - 1) * s + w;

        // 대각선 + 직선
        long c = (x > y) ? y * s + (x - y) * w : x * s + (y - x) * w;

        long result = Math.min(a, Math.min(b, c));

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}

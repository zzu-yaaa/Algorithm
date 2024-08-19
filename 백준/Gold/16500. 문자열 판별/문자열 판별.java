import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        // 단어 목록 A 입력
        Set<String> a = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(br.readLine());
        }

        // dp 배열 초기화
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; // 빈 문자열은 항상 만들 수 있음

        // dp 배열 갱신
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && a.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 결과 출력
        if (dp[len]) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}

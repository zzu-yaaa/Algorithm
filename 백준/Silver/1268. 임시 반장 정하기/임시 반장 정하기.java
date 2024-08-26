import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        //한 사람과 같은 반이 된 적이 있는 사람들 저장
        Set<Integer> set = new HashSet<>();

        // 결과 저장 배열 - 나랑 같은반 했던 사람 수
        int[] result = new int[n];

        //사람을 기준으로
        for(int i=0;i<n;i++){
            //학년을 돌면서
            for(int j=0;j<5;j++){
                int temp = arr[i][j];
                //나머지 사람들 확인
                for(int k=0;k<n;k++){
                    if(i==k) continue;

                    if(temp == arr[k][j]){
                        set.add(k);
                    }
                }
            }
            result[i] = set.size();
            set.clear();
        }

        int idx = -1;
        int max = -1;
        for(int i=0;i<n;i++){
            if(max < result[i]){
                max = result[i];
                idx = i;
            }
        }

        bw.write(String.valueOf(idx+1));
        bw.flush();

        br.close();
        bw.close();
    }
}

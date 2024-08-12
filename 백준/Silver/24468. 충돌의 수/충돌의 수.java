import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] idx = new int[n];
        int[] dir = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            idx[i] = Integer.parseInt(st.nextToken());
            dir[i] = st.nextToken().equals("R") ? 1 : -1;
        }

        int result = 0;

        while(t>0){
            //지금 위치 구하기
            for (int i = 0; i < n; i++) {
                //벽에 충돌 - 방향을 바꿔준다
                if(idx[i] + dir[i] < 0 || idx[i] + dir[i] > l){
                    dir[i] *= -1;
                }
                idx[i] += dir[i];
            }
            //위치 비교하기
            for (int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    //충돌
                    if(idx[i] == idx[j]){
                        dir[i] *= -1;
                        dir[j] *= -1;
                        result += 1;
                        break;
                    }
                }
            }
            t-=1;
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}

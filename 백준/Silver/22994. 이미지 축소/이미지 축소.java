import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ni = Integer.parseInt(st.nextToken());
        int mj = Integer.parseInt(st.nextToken());
        char[][] in = new char[ni][mj];
        for(int i=0; i<ni;i++) {
            String s = br.readLine();
            for(int j=0; j<mj;j++) {
                in[i][j] = s.charAt(j);
            }
        }

        int x = 0;
        int y = 0;

        int n = 0;
        for(int a = ni; a > 0 ; a--){
            //약수가 아니면 패스
            if(ni % a != 0) continue;

            n = 0;
            for(int b = 0 ; b < mj ; b++){
                //열의 첫번째 값을 임시로 저장
                char temp = in[0][b];
                //한 열을 쭉 돌면서 약수만큼 같은 수가 반복되는지 확인
                for(int c = 0 ; c < ni ; c++){
                    if(c % a == 0){
                        temp = in[c][b];
                    }
                    if(temp != in[c][b]) break;
                    if(c == ni-1) {
                        n += 1;
                    }
                }
                if(b != n-1) break;
            }

            //정답 찾았으면 패스
            if(n == mj) {
                x = a;
                break;
            }
        }

        int m = 0;
        for(int a = mj; a > 0 ; a--){
            //약수가 아니면 패스
            if(mj % a != 0) continue;

            m = 0;
            for(int b = 0 ; b < ni ; b++){
                //행의 첫번째 값을 임시로 저장
                char temp = in[b][0];
                //한 행을 쭉 돌면서 약수만큼 같은 수가 반복되는지 확인
                for(int c = 0 ; c < mj ; c++){
                    if(c % a == 0){
                        temp = in[b][c];
                    }
                    if(temp != in[b][c]) break;
                    if(c == mj-1) {
                        m += 1;
                    }
                }
                if(b != m-1) break;
            }

            //정답 찾았으면 패스
            if(m == ni) {
                y = a;
                break;
            }
        }


        bw.write(String.valueOf(ni/x) + " " + String.valueOf(mj/y) + "\n");
        for (int i = 0; i < ni; i++) {
            boolean hasOutput = false; // 출력할 문자가 있는지 확인
            for (int j = 0; j < mj; j++) {
                if (i % x == 0 && j % y == 0) {
                    bw.write(in[i][j]);
                    hasOutput = true; // 출력할 문자가 있으면 true로 설정
                }
            }
            if (hasOutput) {
                bw.write("\n"); // 문자가 출력된 경우에만 줄바꿈 수행
            }
        }


        bw.flush();

        br.close();
        bw.close();
    }
}

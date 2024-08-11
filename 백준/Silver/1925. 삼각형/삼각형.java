import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] x = new int[3];
        int[] y = new int[3];

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        //세 점이 일직선에 위치 = 어느 두 점의 기울기가 같다
        if(x[0] == x[1] &&  x[1] == x[2] || y[0] == y[1] && y[1] == y[2]){
            bw.write("X");
        }
        else if( (x[0] - x[1]) != 0 && (x[0] - x[2]) != 0 &&
                (double)(y[0] - y[1]) / (x[0] - x[1])  ==  (double)(y[0] - y[2]) / (x[0] - x[2]) ){
            bw.write("X");
        }
        else{
            int a = (x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]);
            int b = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
            int c = (x[2] - x[1]) * (x[2] - x[1]) + (y[2] - y[1]) * (y[2] - y[1]);

            //세 변의 길이가 같다
            if(a==b && a==c){
                bw.write("JungTriangle");
            }
            //두 변의 길이가 같다
            else if(a==b || a==c || b==c){
                int max = Math.max(a,b);
                max = Math.max(max,c);

                //둔각 - 빗변 길이 < 나머지 길이의 합
                if(max == a && a > b+c || max == b && b > c+a || max == c && c > a+b){
                    bw.write("Dunkak2Triangle");
                }
                //직각
                else if(max == a && a == b+c || max == b && b == c+a || max == c && c == a+b){
                    bw.write("Jikkak2Triangle");
                }
                else{
                    bw.write("Yeahkak2Triangle");
                }
            }
            //세 변의 길이가 모두 다르면
            else{
                int max = Math.max(a,b);
                max = Math.max(max,c);

                //둔각 - 빗변 길이 > 나머지 길이의 합
                if(max == a && a > b+c || max == b && b > c+a || max == c && c > a+b){
                    bw.write("DunkakTriangle");
                }
                //직각
                else if(max == a && a == b+c || max == b && b == c+a || max == c && c == a+b){
                    bw.write("JikkakTriangle");
                }
                else{
                    bw.write("YeahkakTriangle");
                }

            }

        }

        bw.flush();

        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static int s;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        s = Integer.parseInt(in[0]);
        int len = in[1].length();

        arr = new char[2*s+3][(s+2)*len + len];
        for(int j=0; j<2*s+3; j++) {
            for (int k = 0; k < (s+2)*len + len; k++) {
                arr[j][k] = ' ';
            }
        }

        for(int i=0; i<len; i++){
            int offset = (s+3) * i;

            switch (in[1].charAt(i)){
                case '1':
                    two(offset); three(offset);
                    break;
                case '2':
                    one(offset); two(offset); seven(offset); five(offset); four(offset);
                    break;
                case '3':
                    one(offset); two(offset); seven(offset); three(offset); four(offset);
                    break;
                case '4':
                    six(offset); seven(offset); two(offset); three(offset);
                    break;
                case '5':
                    one(offset); six(offset); seven(offset); three(offset); four(offset);
                    break;
                case '6':
                    one(offset); six(offset); five(offset); four(offset); three(offset); seven(offset);
                    break;
                case '7':
                    one(offset); two(offset); three(offset);
                    break;
                case '8':
                    one(offset); two(offset); three(offset); four(offset); five(offset); six(offset); seven(offset);
                    break;
                case '9':
                    one(offset); two(offset); three(offset); four(offset); six(offset); seven(offset);
                    break;
                case '0':
                    one(offset); two(offset); three(offset); four(offset); five(offset); six(offset);
                    break;
            }

        }

        for(int j=0; j<2*s+3; j++) {
            for (int k = 0; k < (s + 2) * len + len; k++) {
                bw.write(arr[j][k]);
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    private static void one(int offset){
        for(int i=1;i<=s;i++){
            arr[0][i+offset] = '-';
        }
    }
    private static void two(int offset){
        for(int i=1;i<=s;i++){
            arr[i][s+1+offset] = '|';
        }
    }
    private static void three(int offset){
        for(int i=1;i<=s;i++){
            arr[1+s+i][s+1+offset] = '|';
        }
    }
    private static void four(int offset){
        for(int i=1;i<=s;i++){
            arr[(s+1)*2][i+offset] = '-';
        }
    }
    private static void five(int offset){
        for(int i=1;i<=s;i++){
            arr[1+s+i][offset] = '|';
        }
    }
    private static void six(int offset){
        for(int i=1;i<=s;i++){
            arr[i][offset] = '|';
        }
    }
    private static void seven(int offset){
        for(int i=1;i<=s;i++){
            arr[s+1][i+offset] = '-';
        }
    }
}

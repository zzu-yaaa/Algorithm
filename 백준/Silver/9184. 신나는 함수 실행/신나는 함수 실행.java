import java.io.*;
public class Main{
    static int [][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        int c = Integer.parseInt(inputArr[2]);
        int result;

        while(!(a == -1 && b == -1 && c == -1)){
            result = w(a,b,c);
            bw.write("w("+String.valueOf(a)+", "
                    +String.valueOf(b)+", "
                    +String.valueOf(c)+") = "
                    +String.valueOf(result) +"\n");

            inputArr = br.readLine().split(" ");
            a = Integer.parseInt(inputArr[0]);
            b = Integer.parseInt(inputArr[1]);
            c = Integer.parseInt(inputArr[2]);

        }

        bw.flush();
    }
    static int w(int a, int b, int c) {

        if(inRange(a,b,c) && arr[a][b][c] != 0){
            return arr[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            return arr[20][20][20] = w(20, 20, 20);
        }
        if(a < b && b < c) {
            return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
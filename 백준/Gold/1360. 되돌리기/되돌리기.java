import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] in = new String[n];
        for (int i = 0; i < n; i++) {
            in[i] = br.readLine();
        }
        int find = Integer.parseInt(in[n-1].split(" ")[2]); //찾아야하는 시간
        Stack<Character> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            String[] temp = in[i].split(" ");
            int s = Integer.parseInt(temp[2]);

            //undo한 시간만큼 패스
            if(find < s) continue;

            if(temp[0].equals("type")) {
                stack.push(temp[1].charAt(0));
            }
            else if(temp[0].equals("undo")) {
                int t = Integer.parseInt(temp[1]);
                find = s-t-1;
            }

        }

        int len = stack.size();
        for(int i=0;i<len;i++) {
            bw.write(stack.pop());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

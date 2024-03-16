import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int input = 1;
        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());

            while (input <= value) {
                stack.push(input);
                input += 1;
                sb.append("+").append('\n');
            }

            if (stack.peek() == value) {
                stack.pop();
                sb.append("-").append('\n');
            } else {
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
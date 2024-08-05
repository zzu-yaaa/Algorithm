import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        ArrayList<Integer> in = new ArrayList<>();
        for(int i = 0 ; i < 3*n ; i++) {
            in.add(Integer.parseInt(s[i]));
        }

        Collections.sort(in);
        int temp = in.get((n*2)-1)-in.get(n);
        bw.write(String.valueOf(temp));

        br.close();
        bw.close();
    }
}

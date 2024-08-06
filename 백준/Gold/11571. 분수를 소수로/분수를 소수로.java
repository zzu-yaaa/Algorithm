import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result;

        int t  = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int son = Integer.parseInt(s[0]);
            int mom = Integer.parseInt(s[1]);

            StringBuilder repeat = new StringBuilder();

            int front = son / mom;
            int temp = son % mom;
            ArrayList<Integer> list = new ArrayList<>();
            while(!list.contains(temp) && temp != 0){
                list.add(temp);
                int back = (temp * 10) / mom;
                repeat.append(String.valueOf(back));
                temp = (temp * 10) % mom;
            }

            if(temp == 0){
                result = String.valueOf(front) + "." + repeat.toString() + "(0)\n";
            }
            else{
                int idx = list.indexOf(temp);
                if(idx == 0){
                    result = String.valueOf(front) + ".(" + repeat.toString() + ")\n";
                }
                else{
                    result = String.valueOf(front) + "." + repeat.substring(0,idx) + "(" + repeat.substring(idx) + ")\n";
                }
            }
            bw.write(result);
        }


        bw.flush();

        br.close();
        bw.close();
    }
}

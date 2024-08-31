import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            String[] in = br.readLine().split(" ");

            if(in[0].equals("1")){
                s.push(Integer.parseInt(in[1]));
            }
            else if(in[0].equals("2")){
                if(s.size() != 0){
                    bw.write(String.valueOf(s.pop())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(in[0].equals("3")){
                bw.write(String.valueOf(s.size())+"\n");
            }
            else if(in[0].equals("4")){
                if(s.size() != 0){
                    bw.write("0\n");
                }
                else{
                    bw.write("1\n");
                }
            }
            else if(in[0].equals("5")){
                if(s.size() != 0){
                    bw.write(String.valueOf(s.peek())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}

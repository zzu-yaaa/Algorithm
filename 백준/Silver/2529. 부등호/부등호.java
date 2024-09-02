import java.io.*;
import java.util.*;

public class Main {

    static int k = 0;
    static String[] giho;
    static String min ="";
    static String max="";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        giho = br.readLine().split(" ");

        findMax("");
        findMin("");

        bw.write(max+"\n");
        bw.write(min+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void findMin(String s) {
        if(!min.isEmpty()){
            return;
        }

        if(s.length() == k+1){
            //수 저장하거나 검사하거나
            if(check(s) == 1) min = s;
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(!s.contains(String.valueOf(i))){
                findMin(s+String.valueOf(i));
            }
        }
    }

    private static void findMax(String s) {
        if(!max.isEmpty()){
            return;
        }

        if(s.length() == k+1){
            //수 저장하거나 검사하거나
            if(check(s) == 1) max = s;
            return;
        }

        for(int i = 9; i >= 0; i--){
            if(!s.contains(String.valueOf(i))){
                findMax(s+String.valueOf(i));
            }
        }
    }

    private static int check(String s){
        int cnt = 0;
        for(int i=0;i<k;i++){
            if(giho[i].equals(">")){
                if(s.charAt(i) > s.charAt(i+1)){
                    cnt += 1;
                }
                else return 0;
            }
            else if(giho[i].equals("<")){
                if(s.charAt(i) < s.charAt(i+1)){
                    cnt += 1;
                }
                else return 0;
            }
        }

        if(cnt == k) return 1;

        return 0;
    }

}

import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        func("",n,0);

        bw.write(String.valueOf(result.size()));
        bw.flush();
        br.close(); bw.close();
    }

    private static void func(String s, int n, int idx){
        if(s.length() == n){
            str2int(s);
            return;
        }

        char[] c = {'I','V','X','L'};

        for(int i=idx;i<4;i++){
            func(s+c[i],n, i);
        }
    }

    private static void str2int(String s){
        int temp = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) ==  'I'){
                temp += 1;
            }
            else if(s.charAt(i) ==  'V'){
                temp += 5;
            }
            else if(s.charAt(i) ==  'X'){
                temp += 10;
            }
            else if(s.charAt(i) ==  'L'){
                temp += 50;
            }
        }

        result.add(temp);
    }
}

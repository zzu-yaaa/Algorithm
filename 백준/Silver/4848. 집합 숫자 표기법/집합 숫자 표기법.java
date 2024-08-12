import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String s1 = br.readLine();
            String s2 = br.readLine();
            int a = 0;
            int b = 0;

            if(s1.contains(",")){
                int len = s1.length();
                int temp = 0;
                for(int j=0;j<len;j++){
                    if(s1.charAt(j)==',') temp += 1;
                }
                while(temp > 0){
                    temp = (temp-1) / 2;
                    a += 1;
                }
                a += 1;
            }
            else{
                a = s1.equals("{}") ? 0 : 1;
            }

            if(s2.contains(",")){
                int len = s2.length();
                int temp = 0;
                for(int j=0;j<len;j++){
                    if(s2.charAt(j)==',') temp += 1;
                }
                while(temp > 0){
                    temp = (temp-1) / 2;
                    b += 1;
                }
                b += 1;
            }
            else{
                b = s2.equals("{}") ? 0 : 1;
            }

            bw.write(f(a+b)+"\n");

        }

        bw.flush();

        br.close();
        bw.close();
    }

    private static String f(int n){
        if(n == 0) return "{}";
        if(n == 1) return "{{}}";

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0;i<n;i++){
            sb.append(f(i));
            if(i != n-1) sb.append(",");
        }
        sb.append("}");

        return sb.toString();
    }
}

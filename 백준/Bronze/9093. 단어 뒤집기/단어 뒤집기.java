import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        
        for(int i=0;i<num;i++){
            String str = br.readLine();
            String temp[] = str.split(" ");
            for(int j=0;j<temp.length;j++){
                StringBuffer sb = new StringBuffer(temp[j]);
                String re = sb.reverse().toString();
                bw.write(re);
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
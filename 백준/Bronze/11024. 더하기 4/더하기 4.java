import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int i=0; i< test; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            int sum = 0;
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                sum += a;
            }
            System.out.println(sum);
        }
    }
}
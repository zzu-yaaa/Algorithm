import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n1 = Integer.parseInt(in[0]);
        int n2 = Integer.parseInt(in[1]);
        String one = br.readLine();
        String two = br.readLine();
        int t = Integer.parseInt(br.readLine());

        int len = n1 + n2;
        int[] arr = new int[len];
        for(int i=0;i<n1;i++){
            arr[i] = -1;
        }
        for(int i=n1;i<len;i++){
            arr[i] = 1;
        }

        while(t > 0){
            for(int i=0;i<len-1;i++){
                if(arr[i] == -1 && arr[i+1] == 1){
                    arr[i] = 1;
                    arr[i+1] = -1;
                    i+=1;
                }
            }
            t -= 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            if(arr[i] == -1){
                sb.append(one.substring(one.length()-1));
                one = one.substring(0,one.length()-1);
            }
            else if(arr[i] == 1){
                sb.append(two.charAt(0));
                two = two.substring(1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();
    }
}

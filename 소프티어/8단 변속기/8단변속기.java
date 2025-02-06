import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        boolean asc = true;
        boolean des = true;

        for(int i=1;i<8;i++){
            int cur = Integer.parseInt(in[i]);
            if(cur > Integer.parseInt(in[i-1])){
                des = false;
            }
            else{
                asc = false;
            }
        }

        if(asc){
            bw.write("ascending");
        }
        else if(des){
            bw.write("descending");
        }
        else{
            bw.write("mixed");
        }

        bw.flush();
    }
}
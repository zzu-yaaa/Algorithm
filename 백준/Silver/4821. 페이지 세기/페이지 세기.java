import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        Set<Integer> result = new HashSet<>();
        while(p != 0){
            String[] s = br.readLine().split(",");
            for (String str : s) {
                if(str.contains("-")){
                    s = str.split("-");
                    int low = Integer.parseInt(s[0]);
                    int high = Integer.parseInt(s[1]);
                    if(low>high){
                        continue;
                    }
                    for(int i=low; i<=high && i<=p; i++){
                        result.add(i);
                    }
                }
                else{
                    int temp = Integer.parseInt(str);
                    if(temp > p){
                        continue;
                    }
                    result.add(temp);
                }
            }
            bw.write(String.valueOf(result.size())+ "\n");
            p = Integer.parseInt(br.readLine());
            result = new HashSet<>();
        }

        br.close();
        bw.close();
    }
}

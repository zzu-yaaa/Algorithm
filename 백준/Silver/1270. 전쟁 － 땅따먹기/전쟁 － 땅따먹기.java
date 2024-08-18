import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);

            Map<String, Integer> map = new HashMap<>();
            for(int j=1; j<=t; j++) {
                //key : 군대 번호, value : 병사 수
                map.put(s[j], map.getOrDefault(s[j], 0) + 1);
            }

            int find = 0;
            String result = "";
            for (String key : map.keySet()) {
                if(map.get(key) > t/2){
                    find = 1;
                    result = key;
                }
            }

            if(find == 1){
                bw.write(result+"\n");
            }
            else{
                bw.write("SYJKGW\n");
            }


        }


        bw.flush();

        br.close();
        bw.close();
    }
}

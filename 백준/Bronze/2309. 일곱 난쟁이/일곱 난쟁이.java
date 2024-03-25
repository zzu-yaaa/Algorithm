import java.io.*;
import java.util.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arr = new ArrayList<>();
        int height=0;
        for(int i = 0;i<9;i++){
            arr.add(Integer.parseInt(br.readLine()));
            height += arr.get(i);
        }

        int flag = 0;
        for(int i = 0; i<9;i++){
            for(int j=i+1;j<9;j++){
                if(height - arr.get(i) - arr.get(j) == 100){
                    arr.remove(i);
                    arr.remove(j-1);
                    flag = 1;
                }
                if (flag == 1) break;
            }
            if (flag == 1) break;
        }

        Collections.sort(arr);
        for (Integer i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
    }
}
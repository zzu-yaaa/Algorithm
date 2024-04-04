import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int K;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int max = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        K = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        for(int i = 0; i<K;i++){
            arr.add(Integer.parseInt(inputArr[i]));
        }
        Collections.sort(arr);

        func(0);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void func(int num){
        if(num > N){
            return;
        }
        max = Math.max(max,num);
        for(int i = K-1;i>=0;i--){
            func(num*10 + arr.get(i));
        }
    }
}
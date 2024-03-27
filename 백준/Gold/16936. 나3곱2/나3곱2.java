import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static ArrayList<Long> arr = new ArrayList<>();
    static boolean[] used;
    static long[] result;
    static int found = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        result = new long[N];
        used = new boolean[N];
        String[] inArr = br.readLine().split(" ");
        for(int i = 0; i<N;i++){
            arr.add(i, Long.parseLong(inArr[i]));
        }
        Collections.sort(arr);

        for(int i =0 ; i<N;i++){
            if(found == 1){
                break;
            }
            cal(0,i);
        }


        for(int i = 0;i<N;i++){
            bw.write(String.valueOf(result[i])+" ");
        }
        bw.flush();
    }

    private static void cal(int cnt, int index){
        if(result[N-1] != 0){
            found = 1;
            return;
        }
        if(!used[index]){
            used[index] = true;
            result[cnt] = arr.get(index);
            if(arr.get(index)%3==0){
                for(int i=0;i<index;i++){
                    if(arr.get(index)/3 == arr.get(i)){
                        cal(cnt+1, i);
                        break;
                    }
                }
            }
            for(int i = index+1;i<N;i++){
                if(arr.get(index)*2 == arr.get(i)){
                    cal(cnt+1, i);
                    break;
                }
            }
        }
        used[index] = false;
    }
}
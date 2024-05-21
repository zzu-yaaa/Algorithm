import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] travel;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }

        String[] inputArr;
        for(int i=1;i<=n;i++){
           inputArr = br.readLine().split(" ");
           for(int j=1;j<=n;j++){
               int x = Integer.parseInt(inputArr[j-1]);
               if (x == 0) {
                   continue;
               }
               union(i,j);
           }
        }

        inputArr = br.readLine().split(" ");
        Set<Integer> trav = new HashSet<>();
        //travel = new int[m];
        for(int i=0;i<m;i++){
            //travel[i] = Integer.parseInt(inputArr[i]);
            trav.add(Integer.parseInt(inputArr[i]));
        }

        int result = 0;
        boolean possible = true;
        int cnt = 0;
        for(int i : trav){
            if(cnt == 0){
                result = find(i);
            }
            if(find(i) != result){
                possible = false;
            }
            cnt++;
        }

        if(possible){
            bw.write("YES");
        }
        else{
            bw.write("NO");
        }

//        for (int i : arr) {
//            bw.write(String.valueOf(i)+" ");
//        }
        bw.flush();
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        arr[y] = x;
    }

    private static int find(int a){
        if(arr[a] == a){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}

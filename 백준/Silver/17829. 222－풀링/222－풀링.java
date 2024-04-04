import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        String [] temp;
        for(int i = 0; i<N;i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bw.write(String.valueOf(func(0,0,N)));

        bw.flush();
    }

    private static int func(int x, int y, int n){
        ArrayList<Integer> temp;
        if(n == 2){
            temp = new ArrayList<>();
            int idx = 0;
            for(int i = x;i<x+2;i++){
                for(int j = y;j<y+2;j++){
                    temp.add(arr[i][j]);
                }
            }
            Collections.sort(temp);
            return temp.get(2);
        }

        int num1 = func(x,y,n/2);
        int num2 = func(x,y+n/2,n/2);
        int num3 = func(x+n/2,y,n/2);
        int num4 = func(x+n/2,y+n/2,n/2);

        temp = new ArrayList<>();
        temp.add(num1);
        temp.add(num2);
        temp.add(num3);
        temp.add(num4);
        Collections.sort(temp);

        return temp.get(2);

    }
}
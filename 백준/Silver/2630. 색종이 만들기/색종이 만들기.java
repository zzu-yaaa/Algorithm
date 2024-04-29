import java.io.*;

public class Main{
    static int[][] arr;
    static int[] cnt = new int[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i<N;i++){
            String[] inputArr = br.readLine().split(" ");
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        func(0,0,N);

        bw.write(String.valueOf(cnt[0])
        +"\n" + String.valueOf(cnt[1]));
        bw.flush();
    }

    private static void func(int startX, int startY, int num){
        if(num == 1){
            if(arr[startX][startY] == 0 ){
                cnt[0] ++;
            }
            else if(arr[startX][startY] == 1 ){
                cnt[1] ++;
            }
            return;
        }

        if(!allSame(startX,startY,num)){
            num = num/2;
            func(startX,startY,num);
            func(startX,startY+num,num);
            func(startX+num,startY,num);
            func(startX+num,startY+num,num);
        }

    }

    private static boolean allSame(int startX, int startY, int num){
        int first = arr[startX][startY];
        for(int i = startX; i < startX+num;i++){
            for(int j = startY; j<startY+num;j++){
                if(first != arr[i][j]){
                    return false;
                }
            }
        }
        cnt[first]++;
        return true;
    }
}
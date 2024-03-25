import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int cnt6 = 0;
        int num = 666;
        int temp = 0;
        while (cnt < N){
            temp = num;
            cnt6 = 0;
            while(temp > 0){
                if(temp%10 == 6){
                    cnt6 +=1;
                }
                else{
                    cnt6 = 0;
                }

                if(cnt6 == 3){
                    cnt ++;
                    break;
                }
                temp = temp/10;
            }
            num += 1;
        }

        bw.write(String.valueOf(num - 1));
        bw.flush();
    }
}
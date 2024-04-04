import java.io.*;

public class Main{
    public static StringBuffer result = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        int N;
        while((input = br.readLine()) != null){
            N = Integer.parseInt(input);
            result = new StringBuffer();
            func(N);
            bw.write(result+"\n");
        }
        bw.flush();
    }

    private static void func(int num){
        if(num==0) {
            result.append("-");
            return;
        }

        func(num-1);
        int temp = 1;
        for(int i = 0; i<num-1;i++){
            temp *= 3;
        }
        for(int i = 0;i<temp;i++){
            result.append(" ");
        }
        func(num-1);
    }
}
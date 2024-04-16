import java.io.*;

public class Main{
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++){
            String input = br.readLine();
            cnt = 0;
            bw.write(String.valueOf(isPalindrome(input))
            + " " +String.valueOf(cnt) + "\n");
        }

        bw.flush();
    }

    private static int isPalindrome(String input){
        return func(input, 0, input.length()-1);
    }

    private static int func(String input, int l, int r){
        cnt += 1;
        if(l >= r) return 1;
        else if(input.charAt(l) != input.charAt(r)){
            return 0;
        }
        else return func(input, l+1, r-1);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n+1];
        int[] alphabet = new int[26];

        for(int i = 0; i<n;i++){
            input[i] = br.readLine();
            int len = input[i].length();
            int temp = len;
            for(int j=0;j<len;j++){
                alphabet[input[i].charAt(j)-'A'] += (int) Math.pow(10, temp = temp-1);
            }
        }

        Arrays.sort(alphabet);

        int num = 9;
        int result = 0;
        for(int i= alphabet.length-1;i>=0;i--){
            if(alphabet[i] == 0){
                break;
            }
            result += num * alphabet[i];
            num -= 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

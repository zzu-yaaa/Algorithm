import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.toUpperCase();

        int[] alphabet = new int[26];

        for(int i=0;i<str.length();i++){
            alphabet[str.charAt(i)-'A'] += 1;
        }

        int max = -1;
        char answer = '?';
        for(int i=0;i<26;i++){
            if(alphabet[i] >= max){
                if(alphabet[i] == max){
                    answer = '?';
                }
                else{
                    max = alphabet[i];
                    answer = (char) ('A'+i);
                }
            }
        }

        bw.write(answer);
        bw.flush();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.toUpperCase();

        Map<Character,Integer> m = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            m.put(str.charAt(i), m.getOrDefault(str.charAt(i), 0) + 1);
        }

        int max = -1;
        Character answer = null;
        for(Character c : m.keySet()){
            if(m.get(c) >= max){
                if(m.get(c)==max){
                    answer = '?';
                }
                else{
                    max = m.get(c);
                    answer = c;
                }
            }
        }

        bw.write(answer);
        bw.flush();
    }
}

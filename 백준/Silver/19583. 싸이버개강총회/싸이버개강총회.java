import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String S = input[0];
        String E = input[1];
        String Q = input[2];

        String temp, time, name;
        String[] log;
        HashSet<String> attend = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        while((temp = br.readLine()) != null){
            log = temp.split(" ");
            time = log[0];
            name = log[1];

            if(time.compareTo(S) <= 0){
                attend.add(name);
            }

            if(time.compareTo(E)>=0 && time.compareTo(Q) <= 0){
                if(attend.contains(name)){
                    result.add(name);
                }
            }
        }

        bw.write(String.valueOf(result.size()));
        bw.flush();
    }
}
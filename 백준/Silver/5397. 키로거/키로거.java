import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        String input;
        int inputLen;
        Stack<Character> result = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for(int i = 0; i<test;i++){
               input = br.readLine();
               inputLen = input.length();
               result.clear();
               temp.clear();
               for(int j = 0; j<inputLen;j++){
                   if(input.charAt(j) == '<'){
                        if(result.size() > 0){
                            temp.push(result.pop());
                        }
                   }
                   else if(input.charAt(j) == '>'){
                        if(temp.size() > 0){
                            result.push(temp.pop());
                        }
                   }
                   else if(input.charAt(j) == '-'){
                        if(result.size()>0){
                            result.pop();
                        }
                   }
                   else{
                        result.push(input.charAt(j));
                   }
               }
               while(!temp.isEmpty()){
                   result.push(temp.pop());
               }
            for (Character c : result) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
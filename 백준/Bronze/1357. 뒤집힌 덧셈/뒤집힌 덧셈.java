import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        String x = inputArr[0];
        String y = inputArr[1];
        
        int result = Rev(String.valueOf(Rev(x)+Rev(y)));
        
        bw.write(String.valueOf(result));
        bw.flush();
        
    }
    
    private static int Rev(String a){
        StringBuilder revResult = new StringBuilder();
        
        int len = a.length();
        for(int i=len-1;i>=0;i--){
            revResult.append(a.charAt(i));
        }
        
        return Integer.parseInt(revResult.toString());
    }
}
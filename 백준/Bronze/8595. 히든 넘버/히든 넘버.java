import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        String temp = "";
        long sum = 0;
        for(int i = 0; i<len; i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                temp += str.charAt(i);
            }
            else{
                if(temp.length()>0){
                    sum += Long.parseLong(temp);
                    temp = "";
                }
            }
        }
        if(temp.length()>0){
            sum += Long.parseLong(temp);
            temp = "";
        }
        System.out.println(sum);
    }
}
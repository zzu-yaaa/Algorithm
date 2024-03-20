import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        for(int i=1;i<=num;i++){
            String str = br.readLine();
            String temp[] = str.split(" ");
            System.out.print("Case #"+i+":");
            for(int j=temp.length-1;j>=0;j--){
                System.out.print(" "+temp[j]);
            }
            System.out.println();
        }
    }
}
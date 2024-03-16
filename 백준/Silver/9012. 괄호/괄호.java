import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String input;
        int len;
        int result = 0;
        for(int i=0;i<num;i++) {
            input = br.readLine();
            len = input.length();
            if(len%2 == 1){
                bw.write("NO\n");
            }
            else{
                for(int j=len-1;j>=0;j--){
                    if(input.charAt(j) == '('){
                        result -= 1;
                        if(result < 0){
                            break;
                        }
                    }
                    else{
                        result += 1;
                    }
                }
                if(result == 0){
                    bw.write("YES\n");
                }
                else{
                    bw.write("NO\n");
                    result = 0;
                }
            }


        }

        bw.flush();
    }
}
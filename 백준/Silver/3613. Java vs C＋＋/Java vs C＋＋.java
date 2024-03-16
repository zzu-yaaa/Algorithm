import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        if(input.contains("_")){
            if(isC(input)){
                String[] temp = input.split("_");
                bw.write(temp[0]);
                for (int i = 1; i < temp.length; i++) {
                    String str = temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1);
                    bw.write(str);
                }
            }
            else{
                System.out.println("Error!");
            }
        }
        else if(isJava(input)){
            int len = input.length();
            for (int i = 0; i < len; i++) {
                if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    bw.write("_");
                    bw.write(Character.toLowerCase(input.charAt(i)));
                } else {
                    bw.write(input.charAt(i));
                }
            }
        }
        else{
            System.out.println("Error!");
        }


        bw.flush();
    }

    private static boolean isC(String input){
        if(input.contains("__") || input.startsWith("_")
            || input.endsWith("_")
            || !input.toLowerCase().equals(input) ){
            return false;
        }
        else{
            return true;
        }
    }

    private static boolean isJava(String input){
        if(input.charAt(0)>='A'&&input.charAt(0)<='Z'){
            return false;
        }
        else{
            return true;
        }
    }
}
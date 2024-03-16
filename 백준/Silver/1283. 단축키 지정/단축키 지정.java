import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String key = "";
        key += line.charAt(0);
        bw.write("["+line.substring(0,1)+"]"+line.substring(1)+"\n");
        int flag = -1;
        for(int i=1;i<num;i++){
            line = br.readLine();
            if((flag = isInWord(line, key)) > -1){
                String[] temp = line.split(" ");
                for(int j=0;j<temp.length;j++){
                    if(j == flag){
                        bw.write("["+temp[j].charAt(0)+"]"+temp[j].substring(1));
                        key += temp[j].charAt(0);
                    }
                    else{
                        bw.write(temp[j]);
                    }
                    bw.write(" ");
                }
                bw.write("\n");
            }
            else{
                if((flag = isInAlphabet(line, key)) > -1){
                    int len = line.length();
                    for(int j=0;j<len;j++){
                        if(j == flag){
                            bw.write("["+line.charAt(j)+"]");
                            key += line.charAt(j);
                        }
                        else{
                            bw.write(line.charAt(j));
                        }
                    }
                    bw.write("\n");
                }
                else{
                    bw.write(line + "\n");
                }
            }
        }

        bw.flush();
    }

    private static int isInWord(String line, String key){
        String[] temp = line.split(" ");
        for (int i=0;i<temp.length;i++) {
            if(!key.toLowerCase().contains(Character.toString(temp[i].charAt(0)).toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    private static int isInAlphabet(String line, String key){
        int len = line.length();
        for(int i=0;i<len;i++) {
            if(Character.toString(line.charAt(i)).equals(" ")){
                continue;
            }
            else{
                if(!key.toLowerCase().contains(Character.toString(line.charAt(i)).toLowerCase())){
                    return i;
                }
            }
        }
        return -1;
    }
}
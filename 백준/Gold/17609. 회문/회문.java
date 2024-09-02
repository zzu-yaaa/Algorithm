import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            String in = br.readLine();

            int start = 0;
            int end = in.length()-1;
            int cnt = 0;

            while(start < end){

                //시작과 끝 알파벳이 안맞으면
                if(in.charAt(start) != in.charAt(end)){
                    //오른쪽으로 이동해서 회문인지 확인
                    int temp1 = start;
                    int temp2 = end-1;
                    int right = 1;
                    while(temp1 < temp2){
                        if(in.charAt(temp1) != in.charAt(temp2)){
                            right = 0;
                            break;
                        }
                        temp1 += 1;
                        temp2 -= 1;
                    }


                    //완쪽으로 이동해서 회문인지 확인
                    temp1 = start+1;
                    temp2 = end;
                    int left = 1;
                    while(temp1 < temp2){
                        if(in.charAt(temp1) != in.charAt(temp2)){
                            left = 0;
                            break;
                        }
                        temp1 += 1;
                        temp2 -= 1;
                    }

                    if(right == 1 || left == 1){
                        cnt = 1;
                    }
                    else{
                        cnt = 2;
                    }
                    break;

                }

                start += 1;
                end -= 1;
            }

            bw.write(cnt + "\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }
}

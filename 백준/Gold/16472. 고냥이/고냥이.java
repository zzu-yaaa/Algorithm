import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int start = 0;
        int end = 0;
        int[] set = new int[26];
        int cnt = 0; //현재까지 나온 알파벳의 개수
        int max = -1;

        while(start <= end && end < input.length()){
            int temp = input.charAt(end)-'a';
            if(cnt >= n){
                if(set[temp] != 0){
                    //중복 문자, 문자열에 포함 가능
                    set[temp] += 1;
                    max = Math.max(max, end-start+1);
                    end += 1;
                }
                else{
                    //새로운 문자, 문자열에 포함 불가
                    temp = input.charAt(start) - 'a';
                    set[temp] -= 1;
                    if(set[temp]==0) cnt -= 1;
                    start += 1;
                }
            }
            else{
                //문자열에 포함 가능
                if(set[temp] == 0) cnt+=1;
                set[temp] += 1;
                max = Math.max(max, end-start+1);
                end += 1;
            }

        }

        bw.write(String.valueOf(max));

        bw.flush();
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<String> nums = new ArrayList<>();
    static ArrayList<String> in = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> result = new ArrayList<>();

        //입력
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            in.add(br.readLine());
        }

        //모든 세자리수 만들기
        func("");

        int cnt = 0;
        for (String num : nums) {
            cnt = 0;
            for(int i=0;i<n;i++){
                if(baseball(num,i) == 1){
                    cnt += 1;
                }
            }
            if(cnt == n){
                result.add(num);
            }
        }

        bw.write(String.valueOf(result.size()));

        bw.flush();
        br.close();
        bw.close();
    }

    private static void func(String s) {
        if(s.length() == 3){
            nums.add(s);
            return;
        }

        for(int i=1;i<=9;i++){
            if(!s.contains(String.valueOf(i))){
                func(s+String.valueOf(i));
            }
        }
    }

    private static int baseball(String num, int i) {
        String[] temp = in.get(i).split(" ");
        int st = 0;
        int ball = 0;

        for (int j = 0; j < 3; j++) {
            //숫자 포함
            if (num.contains(temp[0].charAt(j) + "")) {
                if(num.charAt(j) == temp[0].charAt(j)){
                    st += 1;
                }
                else{
                    ball += 1;
                }
            }
        }

        if(String.valueOf(st).equals(temp[1]) &&
                String.valueOf(ball).equals(temp[2])){
            return 1;
        }

        return 0;
    }
}

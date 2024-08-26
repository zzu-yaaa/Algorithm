import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        int cnt = 0;
        int max = -1;
        ArrayList<Integer> correct = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = arr.get(i);
            //특정 원소값을 기준으로 나오는 올바른 배열 저장
            for(int j=1;j<=4;j++){
                correct.add(temp+j);
            }

            //다음 4개 원소 중에 올바른 배열에 포함되는 애들만 카운팅
            for(int j=1;j<=4 && i+j<n; j++){
                if(correct.contains(arr.get(i+j))){
                    cnt += 1;
                }
            }

            //가장 많이 포함된 경우를 찾아서 몇개가 부족한지 뺄거임
            max = Math.max(max,cnt);
            correct.clear();
            cnt = 0;
        }

        bw.write(String.valueOf(4-max));

        bw.flush();

        br.close();
        bw.close();
    }
}

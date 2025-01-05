import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        for(int i=0;i<c;i++){
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);

            int tot = 0;
            for(int j=0;j<n;j++){
                tot += Integer.parseInt(in[j+1]);
            }
            double ave = tot/(double)n;

            int cnt = 0;
            for(int j=0;j<n;j++){
                if(Integer.parseInt(in[j+1]) > ave){
                    cnt += 1;
                }
            }

            double ans = cnt/(double)n * 100;

            bw.write(String.format("%.3f",ans)+"%");
            bw.write("\n");
        }

        bw.flush();
    }
}

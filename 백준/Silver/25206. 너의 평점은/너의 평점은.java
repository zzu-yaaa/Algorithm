import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double totCredit = 0;
        double temp = 0;

        for(int i=0;i<20;i++){
            String s = br.readLine();
            String[] info = s.split(" ");

            double credit = Double.parseDouble(info[1]);
            totCredit += credit;

            String grade = info[2];

            switch(grade){
                case "P":
                    totCredit -= credit;
                    break;
                case "A+":
                    temp += credit * 4.5;
                    break;
                case "A0":
                    temp += credit * 4.0;
                    break;
                case "B+":
                    temp += credit * 3.5;
                    break;
                case "B0":
                    temp += credit * 3.0;
                    break;
                case "C+":
                    temp += credit * 2.5;
                    break;
                case "C0":
                    temp += credit * 2.0;
                    break;
                case "D+":
                    temp += credit * 1.5;
                    break;
                case "D0":
                    temp += credit * 1.0;
                    break;
                default:
                    break;
            }
        }

        bw.write(String.format("%.5f",temp/totCredit)+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}

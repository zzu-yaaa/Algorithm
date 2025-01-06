import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10001];

        int n = Integer.parseInt(br.readLine());

        for(int i=0 ; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[temp] += 1;
        }

        for(int i=0 ; i<10001 ; i++){
            if(arr[i] != 0){
                for(int j=0 ; j<arr[i] ; j++){
                    bw.write(String.valueOf(i)+"\n");
                }
            }
        }

        bw.flush();

    }
    
}
import java.io.*;
import java.util.*;

public class Main {
    static int A,C,G,T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine()," ");
        A =  Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        G =  Integer.parseInt(st.nextToken());
        T =  Integer.parseInt(st.nextToken());

        int result = 0;
        int a=0, c=0, g=0, t=0;

        for(int i=0; i<=s-p; i++){
            if(i==0){
                for(int j=0;j<p;j++){
                    if(str.charAt(j)=='A'){
                        a+=1;
                    }
                    else if(str.charAt(j)=='C'){
                        c+=1;
                    }
                    else if(str.charAt(j)=='G'){
                        g+=1;
                    }
                    else if(str.charAt(j)=='T'){
                        t+=1;
                    }
                }
                result += compareResult(a,c,g,t);
            }
            else{
                if(str.charAt(i-1)=='A'){
                    a-=1;
                }
                else if(str.charAt(i-1)=='C'){
                    c-=1;
                }
                else if(str.charAt(i-1)=='G'){
                    g-=1;
                }
                else if(str.charAt(i-1)=='T'){
                    t-=1;
                }

                if(str.charAt(i+p-1)=='A'){
                    a+=1;
                }
                else if(str.charAt(i+p-1)=='C'){
                    c+=1;
                }
                else if(str.charAt(i+p-1)=='G'){
                    g+=1;
                }
                else if(str.charAt(i+p-1)=='T'){
                    t+=1;
                }

                result += compareResult(a,c,g,t);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close(); bw.close();
    }

    private static int compareResult(int a, int c, int g, int t) {

        if(A>a){
            return 0;
        }
        if(C>c){
            return 0;
        }
        if(G>g){
            return 0;
        }
        if(T>t){
            return 0;
        }

        return 1;
    }
}

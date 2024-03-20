import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> book = new HashMap<>();
        String temp;
        PriorityQueue<String> result = new PriorityQueue<>();
        int bookCnt=0;
        int max = 1;
        for(int i = 0;i<N;i++){
            temp = br.readLine();
            if(book.containsKey(temp)){
                bookCnt = book.get(temp) + 1;
                book.put(temp,bookCnt);
                if(max < bookCnt) max = bookCnt;
            }
            else{
                book.put(temp,1);
            }
        }

        for (String s : book.keySet()) {
            if(book.get(s) == max){
                result.offer(s);
            }
        }

        bw.write(result.poll()+"\n");
        bw.flush();
    }
}
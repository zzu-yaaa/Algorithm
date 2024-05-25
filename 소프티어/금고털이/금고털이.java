import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int w = Integer.parseInt(inputArr[0]);
        int n = Integer.parseInt(inputArr[1]);

        PriorityQueue<ArrayList<Integer>> q = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o2.get(1), o1.get(1));
            }
        });

        for(int i=0;i<n;i++){
            ArrayList<Integer> set = new ArrayList<>();
            inputArr = br.readLine().split(" ");
            set.add(Integer.parseInt(inputArr[0]));
            set.add(Integer.parseInt(inputArr[1]));

            q.add(set);
        }


        int result = 0;
        while(w>0 && !q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            int m = cur.get(0);
            int p = cur.get(1);
            if(w>=m){
                w = w-m;
                result += m*p;
            }
            else{
                result += w*p;
                w=0;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
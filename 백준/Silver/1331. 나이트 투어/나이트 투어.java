import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arrX = {-2,-1,1,2,2,1,-1,-2};
        int[] arrY = {1,2,2,1,-1,-2,-2,-1};
        int[][] visited = new int[6][6];

        ArrayList<Integer> set;
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for(int i=0;i<36;i++){
            String s = br.readLine();
            int x = 6 - Integer.parseInt(String.valueOf(s.charAt(1)));
            int y = s.charAt(0) - 'A';
            set = new ArrayList<>();
            set.add(x);
            set.add(y);

            q.add(set);
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        cur = q.poll();
        first = cur;
        visited[cur.get(0)][cur.get(1)] = 1;
        int find = 1;
        while(!q.isEmpty() && find == 1){
            ArrayList<Integer> next = q.poll();
            find = 0;

            for(int i=0;i<8;i++){
                if(find == 1){
                    continue;
                }

                int tempX = cur.get(0) + arrX[i];
                int tempY = cur.get(1) + arrY[i];

                //범위 밖
                if(tempX < 0 || tempX >= 6 || tempY < 0 || tempY >= 6){
                    continue;
                }

                if(tempX == next.get(0) && tempY == next.get(1)){
                    find = 1;
                    visited[tempX][tempY] = 1;
                    cur = next;
                }
            }
        }

        int cnt = 0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(visited[i][j] == 1){
                    cnt += 1;
                }
            }
        }

        find = 0;
        for(int i=0;i<8;i++){
            if(find == 1){
                continue;
            }

            int tempX = cur.get(0) + arrX[i];
            int tempY = cur.get(1) + arrY[i];

            //범위 밖
            if(tempX < 0 || tempX >= 6 || tempY < 0 || tempY >= 6){
                continue;
            }

            if(tempX == first.get(0) && tempY == first.get(1)){
                find = 1;
            }
        }

        if(q.isEmpty() && cnt == 36 && find == 1){
            bw.write("Valid");
        }
        else{
            bw.write("Invalid");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}

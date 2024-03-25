import java.io.*;
import java.util.*;

public class Main{
    static HashMap<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());

        int num;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        String input;
        String[] arr;
        int temp;
        for(int i = 0;i<test;i++){
            num = Integer.parseInt(br.readLine());
            result.clear();
            for(int j = 0; j<num;j++){
                input = br.readLine();
                //삽입
                if(input.contains("I")){
                    arr = input.split(" ");
                    temp = Integer.parseInt(arr[1]);
                    max.offer(temp);
                    min.offer(temp);
                    if(result.containsKey(temp)){
                        result.put(temp, result.get(temp)+1);
                    }
                    else{
                        result.put(temp, 1);
                    }
                }
                //삭제
                else if(input.contains("D") && !result.isEmpty()){
                    if(input.contains("-1") && !min.isEmpty()){
                        delete(min);
                    }
                    else if(!max.isEmpty()){
                        delete(max);
                    }
                }
            }

            if (result.size() == 0) {
                bw.write("EMPTY\n");
            }
            else {
                int res = delete(max);
                bw.write(String.valueOf(res) + " ");
                if (result.size()>0){
                    bw.write(String.valueOf(delete(min))+"\n");
                }
                else{
                    bw.write(res+"\n");
                }
            }

        }

        bw.flush();
    }

    private static int delete(PriorityQueue<Integer> queue) {
        int temp;
        while (true) {
            temp = queue.poll();
            if(result.containsKey(temp)){
                if (result.get(temp) > 1) {
                    result.put(temp, result.get(temp) - 1);
                } else {
                    result.remove(temp);
                }
                break;
            }
        }
        return temp;
    }
}
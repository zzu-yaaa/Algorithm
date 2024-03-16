import java.io.*;

public class Main{
    
    static int[] deque = new int[20001];
    static int start = 10000;
    static int end = 9999;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(input.contains("push")){
                String[] temp = input.split(" ");
                if(input.contains("front")){
                    push_front(Integer.parseInt(temp[1]));
                }
                else{
                    push_back(Integer.parseInt(temp[1]));
                }
            }
            else if (input.contains("pop_front")){
                bw.write(String.valueOf(pop_front())+"\n");
            }
            else if (input.contains("pop_back")){
                bw.write(String.valueOf(pop_back())+"\n");
            }
            else if (input.contains("size")){
                bw.write(String.valueOf(size())+"\n");
            }
            else if (input.contains("empty")){
                bw.write(String.valueOf(empty())+"\n");
            }
            else if (input.contains("front")){
                bw.write(String.valueOf(front())+"\n");
            }
            else if (input.contains("back")){
                bw.write(String.valueOf(back())+"\n");
            }
        }

        bw.flush();
    }

    private static void push_front(int x){
        start -= 1;
        deque[start]=x;
    }

    private static void push_back(int x){
        end += 1;
        deque[end]=x;
    }

    private static int pop_front(){
        if (size() == 0) {
            return -1;
        }
        else{
            return deque[start++];
        }
    }

    private static int pop_back(){
        if (size() == 0) {
            return -1;
        }
        else{
            return deque[end--];
        }
    }

    private static int size(){
        return end - start + 1;
    }

    private static int empty(){
        if(size()==0){
            return 1;
        }
        else{
            return 0;
        }
    }

    private static int front(){
        if (size() == 0) {
            return -1;
        }
        else{
            return deque[start];
        }
    }

    private static int back(){
        if (size() == 0) {
            return -1;
        }
        else{
            return deque[end];
        }
    }
    
}
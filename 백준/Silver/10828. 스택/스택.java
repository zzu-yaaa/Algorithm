import java.io.*;

public class Main{
    
    static int[] stack = new int[10001];
    static int flag = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int value = -1;

        for(int i=0;i<num;i++){
            String order = br.readLine();
            if(order.contains("push")){
                String[] temp = order.split(" ");
                push(Integer.parseInt(temp[1]));
            }
            else if(order.contains("pop")){
                value = pop();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(order.contains("size")){
                value = size();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(order.contains("empty")){
                value = empty();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(order.contains("top")){
                value = top();
                bw.write(String.valueOf(value)+"\n");
            }
        }

        bw.flush();
    }

    public static void push(int x){
        flag += 1;
        stack[flag] = x;
    }

    public static int pop(){
        if(flag == -1){
            return flag;
        }
        else{
            int value = stack[flag];
            flag -=1;
            return value;
        }
    }

    public static int size(){
        return flag+1;
    }

    public static int empty(){
        if(flag == -1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int top() {
        if(flag == -1){
            return flag;
        }
        else{
            return stack[flag];
        }
    }
}
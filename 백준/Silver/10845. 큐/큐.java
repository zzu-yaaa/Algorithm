import java.io.*;
import java.util.*;

public class Main{
    static int[] queue = new int[10001];
    static int start = 0;
    static int end = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int value = -1;
        for(int i=0;i<num;i++){
            String input = br.readLine();
            if(input.contains("push")){
                String[] temp = input.split(" ");
                push(Integer.parseInt(temp[1]));
            }
            else if(input.contains("pop")){
                value = pop();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(input.contains("size")){
                value = size();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(input.contains("empty")){
                value = empty();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(input.contains("front")){
                value = front();
                bw.write(String.valueOf(value)+"\n");
            }
            else if(input.contains("back")){
                value = back();
                bw.write(String.valueOf(value)+"\n");
            }
        }

        bw.flush();
    }

    private static void push(int x){
        end += 1;
        queue[end] = x;
    }

    private static int pop(){
        if(start>end){
            return -1;
        }
        else{
            return queue[start++];
        }
    }

    private static int size(){
        return end-start+1;
    }

    private static int empty(){
        if(size() == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    private static int front(){
        if(size()==0){
            return -1;
        }
        else{
            return queue[start];
        }
    }

    private static int back(){
        if(size()==0){
            return -1;
        }
        else{
            return queue[end];
        }
    }
}
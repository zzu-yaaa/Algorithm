import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        int V = Integer.parseInt(inputArr[2]);
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<M ; i++){
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);

            graph[a][b] = graph[b][a] = 1;
        }


        DFS(N,V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS(N,V);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void DFS(int N, int v){
//        Stack<Integer> stack = new Stack<>();
//        boolean[] visited = new boolean[N+1];
//
//        stack.push(v);
//        visited[v] = true;
//
//        while(!stack.isEmpty()){
//            int idx = stack.pop();
//            sb.append(idx + " ");
//
//            for(int i = 1;i<=N;i++){
//                if(graph[idx][i] == 1 && visited[i] == false){
//                    stack.add(i);
//                    visited[i] = true;
//                }
//            }
//        }

        visited[v] = true;
        sb.append(v+ " ");

        for(int i = 1;i<=N;i++){
            if(graph[v][i] == 1 && visited[i] == false){
                DFS(N,i);
            }
        }

    }

    private static void BFS(int N, int v){
        Queue<Integer> queue = new LinkedList<>();;

        //큐에 시작값 넣고, 방문 표시
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();
            sb.append(idx + " ");

            for(int i = 1;i<=N;i++){
                if(graph[idx][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static ArrayList<Node>[] graph;

    //노드의 크기, 출발지
    public static int Dijkstra(int n, int start, int end) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[end];


    }

    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        String[] inputArr;
        for(int i = 0 ; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int v = Integer.parseInt(inputArr[0]);
            int w = Integer.parseInt(inputArr[1]);
            int cost = Integer.parseInt(inputArr[2]);

            graph[v].add(new Node(w, cost));
        }

        inputArr = br.readLine().split(" ");
        int start = Integer.parseInt(inputArr[0]);
        int end = Integer.parseInt(inputArr[1]);

        int result = Dijkstra(n, start, end);
        //다익스트라 알고리즘 수행
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
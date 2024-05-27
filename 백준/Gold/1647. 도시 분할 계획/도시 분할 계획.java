import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v1;
    int v2;
    int cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int[] parent;
    static int[] vis;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        vis = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            pq.offer(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        int result = 0;
        int max = -1;
        for(int i=0;i<m;i++){
            Node cur = pq.poll();

            if(find(cur.v1) == find(cur.v2)){
                continue;
            }
            else{
                union(cur.v1, cur.v2);
                result += cur.cost;
                max = cur.cost;
            }
        }

        bw.write(String.valueOf(result - max));
        bw.flush();
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[y] = x;
    }
}

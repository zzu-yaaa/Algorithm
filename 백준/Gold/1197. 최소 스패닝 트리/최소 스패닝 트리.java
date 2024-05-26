import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
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
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i] = i;
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            pq.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int result = 0;
        for(int i=0;i<e;i++){
            Node node = pq.poll();
            if(find(node.v1) == find(node.v2)){
                continue;
            }
            else{
                union(node.v1, node.v2);
                result += node.cost;
            }

        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int find(int a){
        if(a == parent[a]){
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

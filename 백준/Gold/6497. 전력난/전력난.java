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
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0) break;

            parent = new int[m+1];
            for(int i=1;i<=m;i++){
                parent[i] = i;
            }

            int max = 0;
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine()," ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                pq.offer(new Node(v1,v2,cost));
                max += cost;
            }

            int need = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(find(cur.v1) == find(cur.v2)){
                    continue;
                }
                union(cur.v1, cur.v2);
                need += cur.cost;
            }

            bw.write(String.valueOf(max-need)+"\n");
        }

        bw.flush();
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        parent[find(b)] = find(a);
    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<m+1;i++){
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        in = br.readLine().split(" ");
        int s = Integer.parseInt(in[0]);
        int t = Integer.parseInt(in[1]);

        //다익스트라 레츠고
        int[] vis = new int[n+1];
        Arrays.fill(vis,Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s,0));
        vis[s] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<graph[cur.idx].size(); i++){
                Node next = graph[cur.idx].get(i);

                if(vis[next.idx] > vis[cur.idx] + next.cost){
                    vis[next.idx] = vis[cur.idx] + next.cost;
                    q.offer(next);
                }

            }
        }

        bw.write(String.valueOf(vis[t]));

        bw.flush();
        br.close(); bw.close();
    }
}

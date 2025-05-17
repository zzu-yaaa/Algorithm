/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

//=======================bfs=======================
class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        q.offer(node);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node neighbor : cur.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                map.get(cur).neighbors.add(map.get(neighbor));
            }

        }

        return clone;

    }
}

//=======================dfs=======================
import java.util.*;

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Node clone = new Node(node.val);
        map.put(node, clone);
        dfs(node);

        return clone;
    }

    public void dfs(Node node){
        for(Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){
                Node newNode = new Node(neighbor.val);
                map.put(neighbor, newNode);
                dfs(neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}

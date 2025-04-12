import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int[] vis = new int[words.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.word.equals(target)){
                return cur.cnt;
            }
            
            for(int j=0; j<words.length; j++){
                int differ = 0;
                for(int i=0; i<begin.length(); i++){
                    if(cur.word.charAt(i) != words[j].charAt(i)){
                        differ += 1;
                    }
                }
                if(differ == 1 && vis[j] == 0){
                    q.add(new Node(words[j], cur.cnt + 1));
                    vis[j] = 1;
                }
            }
        }
        
        return answer;
    }
}

class Node{
    String word;
    int cnt;
    
    public Node(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}
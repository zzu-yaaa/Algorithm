import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int play;
    
    public Node(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
    
    @Override
    public int compareTo(Node o){
        if(this.play == o.play){
            return Integer.compare(this.idx, o.idx);
        }
        return Integer.compare(o.play, this.play);
    }

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Long> total = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            total.put(genres[i], total.getOrDefault(genres[i],0L) + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));
        
        List<Integer> answer = new ArrayList<>();
        for(String genre : keySet){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(genre)){
                    pq.offer(new Node(i, plays[i]));
                }
            }
            answer.add(pq.poll().idx);
            if(!pq.isEmpty()){
                answer.add(pq.poll().idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
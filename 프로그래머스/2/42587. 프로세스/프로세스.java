import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[] cnt = new int[10]; //우선수위 개수 저장
        Queue<ArrayList> q = new LinkedList<>();
        ArrayList<Integer> process = new ArrayList<>();
        
        int lo = 0;
        for(int input : priorities){
            cnt[input] += 1;
            process = new ArrayList<>();
            process.add(lo++);
            process.add(input);
            q.add(process);
        }
        
        int answer = 1;;
        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            
            int now = 0;
            for(int i=9; i>=1; i--){
                if(cnt[i] != 0){
                    now = i;
                    break;
                }
            }

            if(cur.get(1) == now){
                if(cur.get(0) == location){
                    return answer;
                }
                else{
                    cnt[now] -= 1;
                }
                answer += 1;
            }
            else{
                q.offer(cur);
            }
        }
        
        return answer;
    }
}
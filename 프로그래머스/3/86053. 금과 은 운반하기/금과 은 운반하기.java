class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 400000000000000L;
        
        long answer = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            
            if(inTime(mid, a, b, g, s, w, t) == 1){
                right = mid - 1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private int inTime(long time, int a, int b,
                       int[] g, int[] s, int[] w, int[] t){
        long total = 0;
        long gold = 0;
        long silver = 0;
        
        for(int i=0; i<g.length;i++){
            long cnt = time / (2*t[i]);
            if(time % (2*t[i]) >= t[i]) cnt += 1;
            
            gold += Math.min(g[i], w[i]*cnt);
            silver += Math.min(s[i], w[i]*cnt);
            total += Math.min(g[i]+s[i], w[i]*cnt);
        }
        
        
        if(gold >= a && silver >= b && total >= a+b){
            return 1;
        }
        
        return 0;
        
    }
}
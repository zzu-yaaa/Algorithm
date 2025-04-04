class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        int width = brown + yellow;
        for(int i=3; i*i<=width; i++){
            if(width % i != 0){
                continue;
            }
            
            int x = i;
            int y = width / i;
            
            if(x+y-2 == brown/2){
                answer[0] = y;
                answer[1] = x;
            }
        }
        
        return answer;
    }
}
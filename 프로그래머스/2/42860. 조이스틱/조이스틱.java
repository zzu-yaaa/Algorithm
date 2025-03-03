class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int move = len;
        int left = 0;
        for(int i=0; i<len; i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            
            left = i+1;
            while(left < len && name.charAt(left) =='A'){
                left += 1;
            }
            move = Math.min(move, 
                                Math.min(i+i+(len-left), (len-left)+(len-left)+i));
        }
        answer += move;
        
        return answer;
    }
}
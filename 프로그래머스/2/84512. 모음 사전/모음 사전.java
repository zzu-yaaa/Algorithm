class Solution {
    public int answer = 0;
    public int cnt = 0;
    public String[] alphabet = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        func("", word);
        return answer;
    }
    
    public void func(String str, String word){
        if(str.equals(word)){
            answer = cnt;
            return;
        }
        if(str.length() == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            if (answer > 0) return;
            cnt += 1;
            func(str+alphabet[i], word);
        }
    }
}
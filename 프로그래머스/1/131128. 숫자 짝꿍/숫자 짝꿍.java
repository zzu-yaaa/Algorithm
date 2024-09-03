
class Solution {
    
    public String solution(String X, String Y) {
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(int i=0;i<X.length();i++){
            int temp = Integer.parseInt(X.charAt(i)+"");
            x[temp] += 1;
        }
        
        for(int i=0;i<Y.length();i++){
            int temp = Integer.parseInt(Y.charAt(i)+"");
            y[temp] += 1;
        }
        
        boolean check = true;
        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            //둘 중에 하나라도 0이다 = 특정 숫자를 가지지 않았으면
            if(x[i] == 0 || y[i] == 0) continue;
            
            int min = Math.min(x[i],y[i]);
            if(i == 0 && check){
                sb.append("0");
            }
            else{
                for(int j = 0; j<min;j++){
                sb.append(String.valueOf(i));
                check = false;
                }
            }
        }
        
        String answer = sb.toString();
        
        if(answer.isEmpty()){
            answer = "-1";
        }
        
        return answer;
    }
}
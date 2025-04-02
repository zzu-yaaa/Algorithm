import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;
        
        for(int i=0; i<answers.length; i++){
            int cur = answers[i];
            if(cur == a[i%5]){
                aCnt += 1;
            }
            if(cur == b[i%8]){
                bCnt += 1;
            }
            if(cur == c[i%10]){
                cCnt += 1;
            }
        }
        int max = Math.max(Math.max(aCnt, bCnt),cCnt);

        List<Integer> answer = new ArrayList<>();

        if(max == aCnt){
            answer.add(1);
        }
        if(max == bCnt){
            answer.add(2);
        }
        if(max == cCnt){
            answer.add(3);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
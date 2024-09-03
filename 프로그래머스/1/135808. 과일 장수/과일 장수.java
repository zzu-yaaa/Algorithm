import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int bye = score.length % m;
        Arrays.sort(score);
        
        int answer = 0;
        for(int i = bye ; i < score.length ; i+=m){
            answer += score[i]*m;
        }
        
        
        return answer;
    }
}
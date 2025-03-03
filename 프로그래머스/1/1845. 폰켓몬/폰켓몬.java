import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int size = set.size();
        
        if(size > nums.length/2){
            answer = nums.length/2;
        }
        else{
            answer = size;
        }

        return answer;
    }
}
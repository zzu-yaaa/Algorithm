//최초 풀이

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2 ){
                return key;
            }
        }

        return 0;

    }
}

//회고
class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int cnt = 1;

        for(int i=1; i<nums.length; i++){
            if(val == nums[i]){
                cnt += 1;
            }
            else if(cnt > 0){
                cnt -= 1;
            }
            else{
                val = nums[i];
                cnt += 1;
            }
        }

        return val;

    }
}
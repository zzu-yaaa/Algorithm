//최초 풀이
import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }

        return 0;
    }
}

//개선
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int i=0; i<32; i++){
            int sum = 0;
            int mask = 1 << i;

            for(int num : nums){
                if((num & mask) != 0){
                    sum += 1;
                }
            }

            if(sum%3 != 0){
                result |= mask;
            }

        }

        return result;
    }
}
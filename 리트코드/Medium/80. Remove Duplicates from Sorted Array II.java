//최초 풀이
class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = Integer.MIN_VALUE;
        int cnt = 0;
        int k = 0;

        for(int num: nums){
            if(cur != num){
                nums[k++] = num;
                cur = num;
                cnt = 0;
            }
            else if(cur == num && cnt == 0){
                nums[k++] = num;
                cnt += 1;
            }
        }

        return k;

    }
}

//회고
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for(int i=2; i<nums.length; i++){
            if(nums[i] != nums[k-2]){
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
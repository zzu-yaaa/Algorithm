class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = -200;
        int k = 0;

        for(int num : nums){
            if(cur != num){
                nums[k++] = num;
                cur = num;
            }
        }

        return k;

    }
}
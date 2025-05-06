// 최초 풀이
import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=nums.length-1; i>=0; i--){
            q.offer(nums[i]);
        }

        for(int i=0; i<k; i++){
            q.offer(q.poll());
        }

        for(int i=nums.length-1; i>=0; i--){
            nums[i] = q.poll();
        }

    }
}

//회고
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }
}
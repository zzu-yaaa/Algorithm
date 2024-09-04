class Solution {
    public int solution(int[] nums) {
        
        int len = nums.length;
        int answer = 0;

        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)){
                        answer += 1;
                    }
                }
            }
        }
    
        return answer;
    }
    
    private boolean isPrime(int sum){
        boolean prime = true;
        for(int i = 2; i<sum;i++){
            if (sum % i == 0 ){
                prime = false;
                break;
            }
        }
        return prime;
    }
    
}
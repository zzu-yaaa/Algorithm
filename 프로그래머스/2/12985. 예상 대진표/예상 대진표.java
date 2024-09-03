class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int cnt = check(1,n,a,b,0);
        
        int round = 0;
        while(n > 1){
            n = n/2;
            round += 1;
        }
        
        int answer = round - cnt;

        System.out.println(answer);

        return answer;
    }
    
    
    private int check(int start, int end, int a, int b, int cnt){
        int temp = start + ((end - start + 1) / 2) - 1;
        if(a <= temp && b<= temp){
            return check(start, temp, a, b, cnt + 1);
        }
        else if(a > temp && b> temp){
            return check(temp+1, end, a, b, cnt + 1);
        }
        return cnt;
    }
}
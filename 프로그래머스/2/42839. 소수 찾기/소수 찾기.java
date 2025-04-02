import java.util.*;

class Solution {
    public int solution(String numbers) {
        //숫자 종이 조각
        int[] num = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            num[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        Arrays.sort(num);
        
        //종이조각으로 만들 수 있는 최대값
        String temp = "";
        for(int i = numbers.length() - 1; i >= 0; i--){
            temp += num[i];
        }
        int max = Integer.parseInt(temp);
        
        //최대값 이하에서 모든 소수 구하기 - 소수0, 소수아님1
        int[] sosu = new int[max+1];
        sosu[0] = 1;
        sosu[1] = 1;
        for(int i=2; i*i <= max; i++){
            for(int j = i+i; j<=max; j+=i){
                sosu[j] = 1;
            }
        }
        
        //가능한 모든 수 찾기
        Set<Integer> result = new HashSet<>();
        for(int i=1; i<=num.length; i++){
            int[] vis = new int[num.length];
            func(num, result, vis, "", i);
        }
        
        int answer = 0;
        for(int cur : result){
            if(sosu[cur] == 0) answer += 1;
        }
        
        
        return answer;
    }
    
    public void func(int[] num, Set<Integer> result, int[] vis, String cur, int len){
        
        if(cur.length() == len){
            result.add(Integer.parseInt(cur));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                func(num, result, vis, cur+num[i], len);
                vis[i] = 0;
            }
        }
        
    }
}
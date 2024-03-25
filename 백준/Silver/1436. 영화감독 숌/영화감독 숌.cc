#include <stdio.h>

int main(){
    int N;
    scanf("%d",&N);
    int cnt = 0;
    int num = 666;
    int cnt_6=0;
    
    while(cnt < N){
        int temp = num;
        cnt_6=0;
        while(temp>0){
            if(temp%10==6){
                cnt_6+=1;
            }
            else{
                cnt_6=0;
            }
            if(cnt_6==3){
                cnt++;
                break;
            }
            temp = temp/10;
        }      
        num++;
    }
    
    printf("%d",num-1);
    
}
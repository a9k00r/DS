#include <stdio.h>



//utilities

int max (int x, int y){
     return ( x>y) ? x:y;
}

int knapsack (int W,int vt[], int wt[], int N){
    
        int nw [N+1][W+1];
    
    for (int i=0;i<=N;i++){
            
        for (int w=0;w<=W;w++){
            if (i==0 || w==0)
                nw[i][w]=0;
            else if (wt[i-1]<W)
                nw[i][w]= max( vt[i-1]+nw[i-1][W-wt[i-1]], nw[i-1][w]);
            else
                nw[i][w]= nw[i-1][w];
        }
}
return  nw[N][W];
}
int main() {
    
    int T; 
    scanf("%d",&T);
    while (T--){
    int N, W;
    scanf("%d n ",&N);
    scanf("%d n",&W);
    int vt[N], wt[N];
    for (int i=0;i<N; i++)
        scanf("%d", &vt[i]);
    for (int i=0;i<N; i++)
        scanf("%d", &wt[i]);
    printf("%d \n", knapsack(W, vt,wt, N));
    
        
    }
    return 0;
}

    


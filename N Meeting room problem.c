#include <bits/stdc++.h>

using namespace std;

struct activity
{
    int start;
    int end;
    int index;
};

bool comparison(activity a , activity b)
{
    return (a.end < b.end);
}

void printActivity(activity arr[],int n)
{
    sort(arr , arr + n,comparison);
    
    int i = 0;
    
    cout << arr[i].index + 1 << " ";
    
    for(int j = 1 ; j < n ; j++)
    {
        if(arr[j].start >= arr[i].end)
        {
            cout << arr[j].index + 1 << " ";
            i = j;
        }
    }
    
    cout << endl;
}


int main() 
{
    int t;
    
    cin >> t;
    
    while(t--)
    {
        int n;
        
        cin >> n;
        
        activity arr[n];
        
        for(int i = 0;i<n;i++)
        {
            cin >> arr[i].start;
            arr[i].index = i;
        }
        
        for(int i = 0;i<n;i++)
        {
            cin >> arr[i].end;
        }
        
        printActivity(arr,n);
    }
    
	return 0;
}
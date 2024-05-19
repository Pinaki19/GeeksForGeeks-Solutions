//{ Driver Code Starts
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    public:
    int findClosest( int n, int k,int arr[]) 
    { 
        // Complete the function
        if(k>=arr[n-1]) return arr[n-1];
        auto it=lower_bound(arr,arr+n,k);
        auto p=prev(it);
        int v1=*it,v2=-1;
        if(p!=arr+n){
            v2=*p;
        }
        return abs(v1-k)<=abs(v2-k) ? v1:v2;
    } 
};

//{ Driver Code Starts.
int main()
{

    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        int arr[n];
        for (int i=0; i<n; i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        cout<<ob.findClosest(n,k,arr)<<endl;
    }
}

// } Driver Code Ends
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
public:
    int getRotation(int* arr,int l,int r){
        if(l==r) return l;
        int mid=l+(r-l)/2;
        if(arr[mid]<arr[mid+1] && arr[l]<=arr[mid])
            return getRotation(arr,mid+1,r);
        return getRotation(arr,l,mid);
    }
    int findMin(int arr[], int n){
       int pos=getRotation(arr,0,n-1);
       pos+=1;
       pos%=n;
       return arr[pos];
    }
};

//{ Driver Code Starts.


int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int i,a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		Solution ob;
		cout<<ob.findMin(a, n)<<endl;
	}
	return 0;
}
// } Driver Code Ends
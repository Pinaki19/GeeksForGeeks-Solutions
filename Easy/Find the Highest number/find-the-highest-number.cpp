//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    int getRotation(auto& a,int l,int r){
        if(l==r) return l;
        int mid=l+(r-l)/2;
        if(a[mid]>=a[l] && a[mid]<a[r])
            return getRotation(a,mid+1,r);
        return getRotation(a,l,mid);
    }
    int findPeakElement(vector<int>& a) 
    {
        // Code here.
        int pos=getRotation(a,0,a.size()-1);
        return a[pos];
    }
};



//{ Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
    	int n;
    	cin >> n;
    	vector<int>a(n);
    	for(int i = 0; i < n; i++)
    		cin>>a[i];
    	Solution ob;
    	int ans = ob.findPeakElement(a);
    	cout << ans << "\n";
    }
	return 0;
}


// } Driver Code Ends
//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int solve(int l,int r,string& s,auto& dp){
        if(dp[l][r]!=-1) return dp[l][r];
        if(l==r) return 1;
        if(l>r) return 0;
        if(s[l]==s[r]){
            return dp[l][r]=max({2+solve(l+1,r-1,s,dp),solve(l+1,r,s,dp),solve(l,r-1,s,dp)});
        }
        return dp[l][r]=max(solve(l+1,r,s,dp),solve(l,r-1,s,dp));
    }
    int kPalindrome(string str, int n, int k)
    {
        vector<vector<int>> dp(n,vector<int> (n,-1));
        int maxPalin=solve(0,n-1,str,dp);
        //cout<<maxPalin<<endl;
        return n-maxPalin<=k;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, k;
        cin>>n>>k;
        string str;
        cin>>str;
        
        Solution ob;
        cout<<ob.kPalindrome(str, n, k)<<endl;
    }
    return 0;
}
// } Driver Code Ends
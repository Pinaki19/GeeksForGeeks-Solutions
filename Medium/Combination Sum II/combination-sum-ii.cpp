//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    void solve(int i,auto& arr,int k,auto& res,auto& temp){
        if(i>=arr.size()||arr[i]>k) return;
        if(arr[i]==k){
            
            temp.push_back(arr[i]);
            // for(int i:temp){
            //     cout<<i<<" ";
            // }
            // cout<<endl;
            res.insert(temp);
            temp.pop_back();
            return solve(i+1,arr,k,res,temp);
        }else{
            temp.push_back(arr[i]);
            solve(i+1,arr,k-arr[i],res,temp);
            temp.pop_back();
            return solve(i+1,arr,k,res,temp);
        }
    }
    vector<vector<int>> CombinationSum2(vector<int> arr,int n,int k)
    {
       sort(arr.begin(),arr.end());
       set<vector<int>> result;
       vector<int> temp;
       solve(0,arr,k,result,temp);
       return vector<vector<int>> (result.begin(),result.end());
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
        vector<int> arr(n);
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        auto obj=ob.CombinationSum2(arr,n,k);
        for(int i=0;i<obj.size();i++)
        {
            for(int j=0;j<obj[i].size();j++)
            {
                cout<<obj[i][j]<<" ";
            }
            cout<<"\n";
        }
        if(obj.size()==0) cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends
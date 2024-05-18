//{ Driver Code Starts


#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution {
public:
    int solve(auto& adj,int src,int& ans,int par=-1){
        //cout<<src<<"  "<<par<<endl;
        int cnt=0;
        for(int t:adj[src]){
            if(t!=par)
                cnt+=solve(adj,t,ans,src);
        }
        if((cnt&1)) {
            ans++;
            return 0;
        }
        return cnt+1;
    }
	int minimumEdgeRemove(int n, vector<vector<int>>edges){
	    // Code here
	    map<int,vector<int>> adj;
	    for(auto e:edges){
	        int s=e[0],d=e[1];
	        adj[s].push_back(d);
	        adj[d].push_back(s);
	    }
	    int ans=0;
	    solve(adj,1,ans);
	    return max(ans-1,0);
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>edges;
		for(int i = 0; i < n-1; i++){
			int x, y;
			cin >> x >> y;
			edges.push_back({x,y});
		}
		Solution obj;
		int ans = obj.minimumEdgeRemove(n, edges);
		cout << ans <<"\n";
	}
	return 0;
}

// } Driver Code Ends
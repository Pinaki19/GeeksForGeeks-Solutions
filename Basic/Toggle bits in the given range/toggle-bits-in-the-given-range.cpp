//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    int toggleBits(int n , int l , int r) {
        l--;r--;
        for(int i=l;i<=r;i++){
            n^=(1<<i);
        }
        return n;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,l,r;
        
        cin>>n>>l>>r;

        Solution ob;
        cout << ob.toggleBits(n,l,r) << endl;
    }
    return 0;
}
// } Driver Code Ends
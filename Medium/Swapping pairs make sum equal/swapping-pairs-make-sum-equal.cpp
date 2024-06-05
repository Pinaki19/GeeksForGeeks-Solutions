//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {

  public:
    int findSwapValues(int a[], int n, int b[], int m) {
        // Your code goes here
        long aSum=accumulate(a,a+n,0L);
        long bSum=accumulate(b,b+m,0L);
        if(aSum==bSum) return 1;
        for(int i=0;i<m;i++) b[i]*=2;

        int diff= aSum-bSum;
        sort(a,a+n);
        sort(b,b+m);
        for(int i=0;i<n;i++){
            int k=2*a[i];
            if(binary_search(b,b+m,k-diff)) return 1;
        }
        return -1;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int a[n];
        int b[m];
        for (int i = 0; i < n; i++)
            cin >> a[i];
        for (int i = 0; i < m; i++)
            cin >> b[i];

        Solution ob;
        cout << ob.findSwapValues(a, n, b, m);
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends
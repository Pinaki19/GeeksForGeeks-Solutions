//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
/*You are required to complete this method*/
using ll=long long;

class Solution {
  public:
    long long max_sum(int a[], int n) {
        // Your code here
        ll Max=0;
        ll tot=0;
        for(int i=0;i<n;i++){
            Max+=i*1ll*a[i];
            tot+=a[i];
        }
        ll cur=Max;
        for(int p=n-1;p>=0;p--){
            cur+= tot-n*1ll*a[p];
            Max=max(Max,cur);
        }
        return Max;
        // 8 3 1 2 ->m=11
        // 2 8 3 1 ->11+12-3*2 = 23-6=17
        // 1 2 8 3 -> 17+13- 3*1= 27
        // 3 1 2 8 ->  27+11-9=29;
    }
};

//{ Driver Code Starts.
int main() {
    int T;
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        int A[N];
        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }
        Solution ob;
        cout << ob.max_sum(A, N) << endl;
        /*keeping track of the total sum of the array*/
    }
}

// } Driver Code Ends
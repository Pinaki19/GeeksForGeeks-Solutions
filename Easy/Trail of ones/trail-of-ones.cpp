//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int numberOfConsecutiveOnes(int n) {
        // code here
       if (n == 2)
        {
            return 1;
        }

        int mod = 1000000007;
        int zeroOnes = 1;
        int onlyOnes = 2;
        int power = 2;

        for (int i = 3; i < n; i++)
        {
            int temp = (zeroOnes + onlyOnes) % mod;
            power = (power * 2) % mod;
            onlyOnes = (power + zeroOnes) % mod;
            zeroOnes = temp;
        }

        return (onlyOnes + zeroOnes) % mod;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.numberOfConsecutiveOnes(N) << endl;
    }
    return 0;
}

// } Driver Code Ends
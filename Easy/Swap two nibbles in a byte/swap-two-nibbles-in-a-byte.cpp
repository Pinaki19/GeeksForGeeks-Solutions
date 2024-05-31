//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int swapNibbles(int n) {
        int8_t x=(int8_t)n;
        bitset<8> bs(x);
        for(int i=0;i<4;i++){
           if(bs[i]&&bs[4+i]|| !bs[i]&&!bs[4+i]) continue;
           if(bs[i]){
              bs[i]=0;
              bs[4+i]=1;
           }else{
              bs[i]=1;
              bs[4+i]=0;
           }
        }
        return (int) bs.to_ulong();
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.swapNibbles(n) << endl;
    }
    return 0;
}
// } Driver Code Ends
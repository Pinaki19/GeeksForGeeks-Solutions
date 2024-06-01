//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string oddEven(string s) {
        // code here
        int freq[26]={0};
        for(char c:s)
            freq[c-'a']++;
        
        int tot=0;
        for(int i=0;i<26;i++){
            if(!freq[i]) continue;
            if(((i&1)==0) && (freq[i]&1))
                tot++;
            else if((i&1) && ((freq[i]&1)==0))
                tot++;
        }
        
        if(tot&1) return "ODD";
        return "EVEN";
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        string s;
        getline(cin, s);

        Solution obj;
        string res = obj.oddEven(s);

        cout << res << "\n";
    }
}

// } Driver Code Ends
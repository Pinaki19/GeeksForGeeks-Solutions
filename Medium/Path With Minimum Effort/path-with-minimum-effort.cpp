//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Matrix {
  public:
    template <class T>
    static void input(vector<vector<T>> &A, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scanf("%d ", &A[i][j]);
            }
        }
    }

    template <class T>
    static void print(vector<vector<T>> &A) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A[i].size(); j++) {
                cout << A[i][j] << " ";
            }
            cout << endl;
        }
    }
};


// } Driver Code Ends

class Solution {
  public:
    int MinimumEffort(int rows, int columns, vector<vector<int>> &heights) {
        vector<pair<int,int>> dir {{0,1},{0,-1},{1,0},{-1,0}};
    
        priority_queue<pair<int,pair<int,int>>,vector<pair<int,pair<int,int>>>,greater<>> pq;
        pq.push({0,{0,0}});
        vector<vector<int>> vis(rows,vector<int> (columns,0));
        auto isvalid=[&](int x,int y)->bool{
            return x>=0 && x<rows && y>=0 && y<columns && vis[x][y]==0;
        };
        int ans=0;
        
        while(pq.size()){
            auto elem=pq.top();pq.pop();
            auto v=elem.first;
            int x=elem.second.first,y=elem.second.second;
            int temp=heights[x][y];
            vis[x][y]=1;
            ans=max(ans,v);
            if(x==rows-1 && y==columns-1) break;
            
            for(auto dr:dir){
                int dx=dr.first,dy=dr.second;
                int nx=x+dx,ny=y+dy;
                if(isvalid(nx,ny)){
                    int diff=abs(temp-heights[nx][ny]);
                    pq.push({diff,{nx,ny}});
                }
            }
        }
        
        return ans;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int rows;
        scanf("%d", &rows);

        int columns;
        scanf("%d", &columns);

        vector<vector<int>> heights(rows, vector<int>(columns));
        Matrix::input(heights, rows, columns);

        Solution obj;
        int res = obj.MinimumEffort(rows, columns, heights);

        cout << res << endl;
    }
}

// } Driver Code Ends
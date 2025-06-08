#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n, height;
    cin >> n;

    stack<pair<int, int> > st;
    st.push(make_pair(100000001, 0));

    for (int i=1; i<=n; i++) {
        cin >> height;
        while (st.top().first < height) {
            st.pop();
        }
        cout << st.top().second << " ";
        st.push(make_pair(height, i));
    }

    return 0;
}
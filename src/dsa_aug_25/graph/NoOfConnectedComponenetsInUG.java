package dsa_aug_25.graph;

import java.util.Arrays;

class NoOfConnectedComponenetsInUdG {
    private int[] p;

    public int countComponents(int n, int[][] edges) {
        p = new int[n];
        Arrays.fill(p,-1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            p[a] = b;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (p[i]==-1) {
                ++ans;
            }
        }
        return ans;
    }

    private int find(int x) {
        if(p[x]==-1){
            return x;
        }
        return find(p[x]);
    }
}

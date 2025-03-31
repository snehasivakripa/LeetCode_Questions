package Graph;

import java.util.Arrays;

public class RedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] parent= new int[n + 1];
        int[] rank= new int[n + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(u,parent) == find(v,parent)) {
                return edge;
            }
            join(u, v,parent,rank);
        }

        return new int[0];
    }

    private int find(int i,int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i],parent); // Path compression
        }
        return parent[i];
    }

    private void join(int u, int v,int[] parent,int[] rank) {
        int rootU = find(u,parent);
        int rootV = find(v,parent);

        if (rootU != rootV) {
            // Union by rank
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public static void main(String[] args){
        int[][] arr= {{1,2},{1,3},{2,3},{3,4}};
        RedundantConnection redundant=new RedundantConnection();
        System.out.println(Arrays.toString(redundant.findRedundantConnection(arr)));
    }
}

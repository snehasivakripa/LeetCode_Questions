package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfOperation {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        int[] parent= new int[len + 1];
        int[] rank= new int[len + 1];
        int count=0;
        // Initialize each node as its own parent
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }

        Set<Integer> vertices=new HashSet<>();
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            vertices.add(u);
            vertices.add(v);

            if (find(u,parent) == find(v,parent)) {
                count++;
            }
            join(u, v,parent,rank);
        }
        if(n-vertices.size()==count)return count;
      return -1;
    }

    private int find(int i,int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i],parent); // Path compression
        }
        return parent[i];
    }

    private void join(int u, int v,int[] parent,int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

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
        int[][] arr= {{0,1},{0,2},{0,3},{1,2}};
        int n=6;
        NumberOfOperation number=new NumberOfOperation();
        System.out.println(number.makeConnected(n,arr));
    }
}

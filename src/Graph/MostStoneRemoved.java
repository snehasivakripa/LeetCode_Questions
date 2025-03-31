package Graph;

import java.util.Arrays;

public class MostStoneRemoved {

    public int removeStones(int[][] stones) {
        int compo=stones.length;
        int[] parent=new int[stones.length];
        int[] rank=new int[stones.length];

        for(int i=0; i<stones.length;i++){
            parent[i]=i;
        }
        for (int[] edge : stones) {
            int u=edge[0];
            int v=edge[1];
            if(find(u,parent)!=find(v,parent)){
                compo= join(u, v,parent,rank,compo);
            }

        }

        return compo;
    }

    private int find(int u,int[] parent) {
        if(parent[u]!=u){
            parent[u]=find(parent[u],parent);
        }
        return parent[u];
    }
    private int join(int u, int v,int[] parent,int[] rank,int comp) {
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
                comp--;
                rank[rootU]++;

            }
        }
        return comp;
    }
    public static void main(String[] args){
        int[][] arr= {{0,0},{0,2},{1,1},{2,0},{2,2}};
        MostStoneRemoved most=new MostStoneRemoved();
        System.out.println(most.removeStones(arr));
    }
}

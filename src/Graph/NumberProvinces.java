package Graph;

import java.util.Arrays;

public class NumberProvinces {

    public int findCircleNum(int[][] isConnected) {
        int[] visited= new int[isConnected.length];
        Arrays.fill(visited,0);
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, int[] visited) {
        visited[i]=1;
        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1 && visited[j]!=1){
                dfs(isConnected,j,visited);
            }
        }
    }

    public static void main(String[] args){
        int[][] arr= {{1,1,1},{1,1,0},{1,0,1}};
        NumberProvinces number=new NumberProvinces();
        System.out.println(number.findCircleNum(arr));
    }
}

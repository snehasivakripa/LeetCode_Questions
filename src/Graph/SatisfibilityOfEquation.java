package Graph;

import java.util.Arrays;

public class SatisfibilityOfEquation {
    public boolean equationsPossible(String[] equations) {
        int[] parent=new int[26];
        for(int i=1;i<26;i++){
            parent[i]=i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                parent[find(eq.charAt(0)-'a',parent)]=find(eq.charAt(3)-'a',parent);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!'&& find(eq.charAt(0)-'a',parent)== find(eq.charAt(3)-'a',parent)) {
                return false;
            }
        }

        return true;
    }

    private int find(int x,int[] parent) {
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }

    public static void main(String[] args){
        String[] arr= {"a==b","b==a"};
        SatisfibilityOfEquation satisfy=new SatisfibilityOfEquation();
        System.out.println(satisfy.equationsPossible(arr));
    }
}

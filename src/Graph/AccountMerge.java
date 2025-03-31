package Graph;

import java.util.*;

public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        int[] rank = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> details = accounts.get(i);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = details.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    join(i, map.get(email), parent, rank);
                }
            }
        }

        HashMap<Integer, List<String>> map1 = new HashMap<>();
        for (String email : map.keySet()) {
            int root = find(map.get(email), parent);
            if (!map1.containsKey(root)) {
                map1.put(root, new ArrayList<>());
            }
            map1.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i : map1.keySet()) {

            List<String> detail = map1.get(i);
            Collections.sort(detail);
            detail.add(0, accounts.get(i).get(0));
            result.add(detail);
        }
        return result;


    }

    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i], parent); // Path compression
        }
        return parent[i];
    }

    private void join(int u, int v, int[] parent, int[] rank) {
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

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>(List.of(
                new ArrayList<>(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                new ArrayList<>(List.of("John", "johnsmith@mail.com", "john00@mail.com")),
                new ArrayList<>(List.of("Mary", "mary@mail.com")),
                new ArrayList<>(List.of("John", "johnnybravo@mail.com"))
        ));
        AccountMerge merge = new AccountMerge();
       System.out.println(Arrays.asList(merge.accountsMerge(accounts)));
    }

}

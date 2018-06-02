import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0]-1)) {
                map.put(edges[i][0]-1, new ArrayList<>());
                //map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]-1).add(edges[i][1]-1);
            if (!map.containsKey(edges[i][1]-1)) {
                map.put(edges[i][1]-1, new ArrayList<>());
                //map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        q.offer(s-1);
        while (!q.isEmpty()) {
            Integer item = q.poll();
            for (Integer node : map.get(item)) {
                if (!visited[node]) {
                    dist[node] = dist[item] + 6;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 1; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}

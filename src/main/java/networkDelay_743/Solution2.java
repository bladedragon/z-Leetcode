package networkDelay_743;

import java.util.*;

public class Solution2 {
        Map<Integer, Integer> dist;
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<int[]>> graph = new HashMap();
            for (int[] edge: times) {
                if (!graph.containsKey(edge[0]))
                    graph.put(edge[0], new ArrayList<int[]>());
                graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
            }

            for (int node: graph.keySet()) {

                Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
            }

            dist = new HashMap();
            for (int node = 1; node <= N; ++node)
                dist.put(node, Integer.MAX_VALUE);

            dfs(graph, K, 0);
            int ans = 0;
            for (int cand: dist.values()) {
                if (cand == Integer.MAX_VALUE) return -1;
                ans = Math.max(ans, cand);
            }
            return ans;
        }

            public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
                if (elapsed >= dist.get(node)) return;
                dist.put(node, elapsed);
                if (graph.containsKey(node))
                    for (int[] info: graph.get(node))
                        dfs(graph, info[1], elapsed + info[0]);
    }

    public static void main(String[] args) {
        int[][] demo = new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},
                {3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        Solution2 solution = new Solution2();
        int i = solution.networkDelayTime(demo,5,5);
        System.out.println(i);
    }
}

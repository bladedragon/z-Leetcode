package networkDelay_743;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    /**
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
        public int Ford(int[][] times, int N, int K) {
            // 构建邻接表，用于存放各个点到各个点的距离
            int[][] graph = new int[N + 1][N + 1];
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        graph[i][j] = i == j ? 0 : -1;
                    }
            }
            // 遍历times填充邻接表
            for (int[] time : times) {
                graph[time[0]][time[1]] = time[2];
            }

            // 遍历所有节点，k 表示使用k节点进行松弛
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        // 使用 k 松弛 i->j 的最短路径
                        if (graph[i][k] != -1 && graph[k][j] != -1) {
                            if (graph[i][j] != -1) {
                                graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                            } else {
                                graph[i][j] = graph[i][k] + graph[k][j];
                            }
                        }
                    }
                }
            }

            int maxDistance = 0;
            // 遍历 K 到所有节点的最短路径的最大值
            for (int i = 1; i <= N; i++) {
                if (graph[K][i] == -1) {
                    return -1;
                }
                maxDistance = Math.max(maxDistance, graph[K][i]);
            }
            return maxDistance;
    }
/**
 * Bellman-Ford算法
 * 固定一点，然后每个节点遍历，看能不能通过这个节点和对应下一个节点的边来松弛固定节点到目标节点的距离
 * 经过多次遍历后，之前松弛失败的边也能重新得到机会，最终得出的distance[v]就是最短距离
 * 可以解决weight是-1的问题
 */
public int bellman_Ford(int[][] times, int N, int K) {
    // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
    int[] distance = new int[N + 1];
    Arrays.fill(distance, -1);
    distance[K] = 0;

    // 进行 N-1 轮的松弛，因为任意两点间的最短路径最多包含 N-1 条边
    for (int i = 1; i <= N - 1; i++) {
        for (int[] time : times) {
            // 源节点
            int u = time[0];
            // 目标节点
            int v = time[1];
            // 一个信号源从源节点到目标节点的时间
            int w = time[2];

            boolean flag = false;
            // 判断能否通过 u->v 缩短 distance[v]（松弛）
            if (distance[u] != -1) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + w;
                } else {
                    distance[v] = Math.min(distance[v], distance[u] + w);
                }

                flag = true;
            }
            //最短路径包含的边最多只会有n-1条
            //因此可以判断是否产生环路的情况
            if(!flag){
                break;
            }
        }
    }

    int maxDistance = 0;
    for (int i = 1; i <= N; i++) {
        if (distance[i] == -1) {
            return -1;
        }
        maxDistance = Math.max(distance[i], maxDistance);
    }

    return maxDistance;
}

/**
 * SPFA算法
 */
public int SPFA(int[][] times, int N, int K) {
    // 构建邻接表，用于存放各个点到各个点的距离
    int[][] graph = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            graph[i][j] = i == j ? 0 : -1;
        }
    }
    // 遍历times填充邻接表
    for (int[] time : times) {
        graph[time[0]][time[1]] = time[2];
    }

    // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
    int[] distance = new int[N + 1];
    Arrays.fill(distance, -1);
    distance[K] = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(K);

    while (!queue.isEmpty()) {
        // 取出队首节点
        int curr = queue.poll();
        for (int i = 1; i <= N; i++) {
            if (graph[curr][i] != -1 && (distance[i] == -1 || distance[i] > distance[curr] + graph[curr][i])) {
                // 当最短距离发生变化且不在队列中时，将该节点加入队列
                distance[i] = distance[curr] + graph[curr][i];
                if (!queue.contains(i)) {
                    queue.add(i);
                }
            }
        }
    }

    int maxDistance = 0;
    for (int i = 1; i <= N; i++) {
        if (distance[i] == -1) {
            return -1;
        }
        maxDistance = Math.max(distance[i], maxDistance);
    }

    return maxDistance;
}

    /**
     * dijktra算法
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N+1][N+1];

        for(int i =1;i <= N;i++){
            for(int j =1;j<=N;j++){
                graph[i][j] = -1;
            }
        }
        for (int[] time:times) {
            graph[time[0]][time[1]] = time[2];

        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] spt = new boolean[N+1];
        dist[K] = 0;

        for(int i=1; i<=N;i++){
            int min_index = -1;
            int minValue = Integer.MAX_VALUE;
            for(int j =1;j<=N;j++){
                if(!spt[j] && minValue > dist[j]) {
                    minValue = dist[j];
                    min_index = j;
                }
            }

            if(min_index <0){
                break;
            }
                spt[min_index] = true;
            for(int j =1;j < N+1;j++){
                if(!spt[j] && graph[min_index][j] != -1){
                    if( dist[j] != Integer.MAX_VALUE){

                            dist[j] = Math.min(dist[j],dist[min_index] + graph[min_index][j]);
                    }else{
                        dist[j] = graph[min_index][j]+dist[min_index];
                    }
                }
            }

        }
        int ans = 0;
        for(int i =1;i <=N;i++){
            if(dist[i]== Integer.MAX_VALUE){
                ans = -1;
                break;
            }
            ans = Math.max(dist[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[][] demo = new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},
                {3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
//                int demo[][] = new int[][] {{1,2,1}};
        int ans = test.networkDelayTime(demo,5,5);
        System.out.println(ans);
    }

}

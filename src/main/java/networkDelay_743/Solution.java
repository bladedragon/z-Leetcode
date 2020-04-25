package networkDelay_743;

public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        boolean[] spt = new boolean[N];
        int[] dist = new int[N];

        for(int i =0; i < N ; i++){
            spt[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist[K-1] = 0;

        int[][] graph = getGraph(times,N);
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.println(graph[i][j]);
//            }
//            System.out.println();
//        }


        for(int i =0; i < N; i++){

            int s = minDist(dist,spt,N);

            spt[s] = true;

            for(int j =0; j < N;j++){
                if(!spt[j] && dist[s] != Integer.MAX_VALUE && graph[s][j] != 0 &&  graph[s][j] + dist[s] < dist[j]){
                    dist[j] = graph[s][j] + dist[s];
                }
            }

        }

        printSolution(dist,N);
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i< N;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(maxValue < dist[i]){
                maxValue = dist[i];
            }
        }
        return maxValue;

    }

    public int minDist(int[] dist, boolean[] spt,int N){

        int minValue = Integer.MAX_VALUE;
        int min_index = -1;

        for(int j =0 ;j < N;j++){
            if(spt[j] == false && dist[j] < minValue){
                minValue = dist[j];
                min_index = j;
            }
        }

        return min_index;
    }

    void printSolution(int dist[],int N)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < N; i++){
            System.out.println(i + " \t\t " + dist[i]);
        }

    }

    public int[][] getGraph(int[][] demo,int N){
    int[][] graph = new int[N+1][N+1];
        for(int i =0; i < N; i++){
            for(int j =0; j< N;j++){
                graph[i][j] = 0;
            }
        }
        for (int[] edge:demo) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        return graph;
    }

    public static void main(String[] args) {
//        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
//                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
//                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
//                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
//                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
//                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
//                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
//                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
//                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
//        int demo[][] = new int[][] {{1,2,1}};
        int[][] demo = new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},
                {3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        Solution solution = new Solution();
        int i = solution.networkDelayTime(demo,5,5);
        System.out.println(i);
    }
}

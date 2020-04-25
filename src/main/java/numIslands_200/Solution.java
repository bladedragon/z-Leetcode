package numIslands_200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIsLands(char[][]  grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands=  0;

        for(int i =0;i<nr;i++){
            for(int j =0;j<nc;j++){
                if(grid[i][j] == '1'){
                    num_islands++;
                    Queue<Integer> neighbors =  new LinkedList<>();
                    neighbors.add((i*nc+j));
                    while(!neighbors.isEmpty()){
                        int id = neighbors.poll();
                        int row = id/nc;
                        int col = id %nc;

                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }
}

package canMeasureWater_365;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OtherPlus {
    final static int MAX = 3;
    private int[] maxContain = new int[]{10,7,3};
    private int[] finalContain = new int[3];
    private boolean flag = false;
    private boolean[][][] visited = new boolean[11][11][11];
    public void pourWater(int x,int y,int z){
        finalContain[0] = x;
        finalContain[1] = y;
        finalContain[2] = z;

        for(int i =0;i<11;i++){
            for(int j =0;j<11;j++){
                for(int k =0;k<11;k++){
                    visited[i][j][k] = false;
                }
            }
        }
        dfs();

    }

    private void dfs() {
        State state = new State();
        state.glass[0] = maxContain[0];
        state.glass[1] =0;
        state.glass[2] = 0;
        if(state.glass[0] == finalContain[0] && state.glass[1] == finalContain[1] && state.glass[2] == finalContain[2]){
            flag = true;
            System.out.println("0");
            return;
        }
        Queue <State> que = new LinkedList<State>();
        que.add(state);

        visited[state.glass[0]][state.glass[1]][state.glass[2]] = true;
        while(!que.isEmpty()){
            State temp = que.poll();

            for(int i =0;i<3;i++){
                if(temp.glass[i] == 0){
                    continue;
                }
                for(int j =0;j<3;j++){

                    State mid = temp;
                    mid.step+=1;

                    if(j == i || temp.glass[j] == maxContain[j]) //同一个杯子或者这个杯子已经满了
                    {
                        continue;
                    }

                    int rest = maxContain[j]-temp.glass[j];
                    if(rest <= temp.glass[i]){
                        mid.glass[j] = maxContain[j];
                        mid.glass[i] -=rest;


                    }else{
                        mid.glass[j] = mid.glass[j] + mid.glass[i];
                        mid.glass[i] = 0;

                    }

                    if(!visited[mid.glass[0]][mid.glass[1]][mid.glass[2]]){
                        if(mid.glass[0] == finalContain[0] && mid.glass[1] == finalContain[1] && mid.glass[2] == finalContain[2]){
                            System.out.println(mid.step);
                            return ;
                        }
                        System.out.println(state.toString());
                        que.add(mid);
                        visited[mid.glass[0]][mid.glass[1]][mid.glass[2]] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OtherPlus o = new OtherPlus();
        o.pourWater(5,5,0);
    }

}

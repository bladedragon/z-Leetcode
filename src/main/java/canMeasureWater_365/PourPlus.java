package canMeasureWater_365;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class  PourPlus{
    static final int MAX = 3;
    //最大可以盛水量
    static int v[] = new int[MAX];
    //最终的容水量
    static int e[] = new int[MAX];
    static boolean vis[][][] = new boolean[300][300][300];
    static int flag;

    public static void main(String [] args)
    {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                v[j] = cin.nextInt();
            }
            for(int j = 0; j < 3; j++){
                e[j] = cin.nextInt();
            }
            flag = 0;
            Init();
            BFS();
            if(flag == 0){
                System.out.println("-1");
            }
        }
    }
    static void Init(){
        for(int i = 0; i < v[0]; i++){
            for(int j = 0; j < v[0]; j++){
                for(int k = 0; k < v[0]; k++){
                    vis[i][j][k] = false;
                }
            }
        }
    }
    static void BFS()
    {
        State start = new State();
        start.glass[0] = v[0];
        start.glass[1] = 0;
        start.glass[2] = 0;
        if(start.glass[0] == e[0] && start.glass[1] == e[1] && start.glass[2] == e[2]){
            flag = 1;
            System.out.println("0");
            return;
        }
        Queue <State> que = new LinkedList<State>();
        que.add(start);
        vis[start.glass[0]][start.glass[1]][start.glass[2]] = true;
        while(!que.isEmpty()){
            State temp = new State();
            temp = que.poll();
            for(int i = 0; i < 3; i++)//核心代码
            {
                if(temp.glass[i] == 0){
                    continue;
                }
                //i向j中倒水
                for(int j = 0; j < 3; j++)
                {
                    if(j == i || temp.glass[j] == v[j]) //同一个杯子或者这个杯子已经满了
                    {
                        continue;
                    }
                    //向其他某个杯子倒
                    State mid = new State();//此处的对象用得很巧妙（不可以定义在这个循环的外面），我之前都是建立一个很大很大的数组用来保存队列，太浪费空间了。
                    mid.glass[0] = temp.glass[0];
                    mid.glass[1] = temp.glass[1];
                    mid.glass[2] = temp.glass[2];
                    mid.step = temp.step+1;

                    //倒满j需要的水
                    int rest = v[j]-temp.glass[j];

                    if(rest <= mid.glass[i]){
                        //j倒满
                        mid.glass[j] = v[j];
                        //i减去倒水量
                        mid.glass[i] = mid.glass[i]-rest;

                        //如果被访问过了
                        if(vis[mid.glass[0]][mid.glass[1]][mid.glass[2]] == false){
                            //如果达到结果，退出循环
                            if(mid.glass[0] == e[0] && mid.glass[1] == e[1] && mid.glass[2] == e[2]){
                            flag = 1;
                            System.out.println(mid.step);
                            return;
                        }
                            //否则添加进入队列
                            que.add(mid);
                            vis[mid.glass[0]][mid.glass[1]][mid.glass[2]] = true;
                            System.out.println(mid.toString());
                        }
                    }else{
                        //j倒不满
                        //顺序不能变，否则mid.glass[i]就被修改了
                        mid.glass[j] = mid.glass[j] + mid.glass[i];
                        mid.glass[i] = 0;

                        if(vis[mid.glass[0]][mid.glass[1]][mid.glass[2]] == false){
                            if(mid.glass[0] == e[0] && mid.glass[1] == e[1] && mid.glass[2] == e[2])
                            {
                                flag = 1;
                                System.out.println(mid.step);
                                return;
                            }
                            que.add(mid);
                            vis[mid.glass[0]][mid.glass[1]][mid.glass[2]] = true;
                            System.out.println(mid.toString());
                        }
                    }
                }
            }
        }
    }
}
class State {
    int glass[] = new int[3];
    int step;

    @Override
    public String toString(){
        return  Arrays.toString(glass);
    }
}
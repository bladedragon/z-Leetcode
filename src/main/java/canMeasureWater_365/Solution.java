package canMeasureWater_365;

import java.util.*;

public class Solution {
    public boolean canMeasureWater(int x,int y,int z){
        if(z ==0){
            return true;
        }
        if(x+y < z){
            return false;
        }
        State initState = new State(0,0);

        Queue<State> queue = new LinkedList<State>();
        Set<State> visited = new HashSet<State>();
        queue.offer(initState);
        visited.add(initState);

        while(!queue.isEmpty()){
            State head = queue.poll();

            int curX = head.x;
            int curY = head.y;

            if(curX == z || curY == z || curX + curY == z){
                return true;
            }
            List<State> nextStates = getNextState(curX,curY,x,y);

            for(State nextState : nextStates){
                if(!visited.contains(nextState)){
                    queue.offer(nextState);
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextState(int curX, int curY, int x, int y) {
        List<State> nextStates = new ArrayList<State>(8);

        // 外部加水，使得 A 满
        State nextState1 = new State(x,curY);
        // 外部加水，使得 B 满
        State nextState2 = new State(curX,y);

        // 把 A 清空
        State nextState3 = new State(0,curY);
        // 把 A 清空
        State nextState4 = new State(curX,0);

        // 以下四个状态，对应操作 3
        // 从 A 到 B，使得 B 满，A 还有剩
        State nextState5 = new State(curX - (y - curY), y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        State nextState6 = new State(0, curX + curY);

        // 从 B 到 A，使得 A 满，B 还有剩余
        State nextState7 = new State(x, curY - (x - curX));
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        State nextState8 = new State(curX + curY, 0);

        if(curX <x){
            nextStates.add(nextState1);
        }
        if(curY < y){
            nextStates.add(nextState2);
        }

        if(curX >0){
            nextStates.add(nextState3);
        }
        if(curY >0){
            nextStates.add(nextState4);
        }

        // 有剩余才倒
        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        // 倒过去倒不满才倒
        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }


    private class State{
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public State(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "State{"+"x="+x+",y="+y+"}";
        }
        @Override
        public boolean equals(Object o){
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
}

package canMeasureWater_365;

public class Solution2 {
    public boolean canMeasureWater(int x,int y,int z){
        if(x > y){
            int temp = x;
            x = y;
            y = x;
        }
        //因为每次都是小杯子装满水往大杯子中倒水，倒完后小杯子剩余水量总是0
        //所以只需要跟踪大杯子剩余水量即可知道整个倒水的操作过程
        System.out.println("第二个杯子的水量为: " + 0);

        //先倒一次水，主要是为了处理倒水失败的情况
        int flag = x % y;
        System.out.println("第二个杯子的水量为: "+x);

        if(flag == z) {
            System.out.println("小杯往大杯倒一次水即可实现目标");
            return true;
        }

        int count = 2;
        while(true) {
            int remain = (count * x) % y;
            System.out.println("第二个杯子的水容量: "+remain);

            if(remain == z) {
                System.out.println("倒水成功，得到了目标水量");
                return true;
            }else if(remain == flag) {//得到循环数列，实现不了目标
                System.out.println("倒水失败，得不到目标水量");
                break;
            }

            count++;
        }
        return false;
    }
}

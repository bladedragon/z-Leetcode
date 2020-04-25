package countOfAtoms_726;

import java.util.*;

public class Solution {

    //保证递归正常向前解析
    int i;
    public  String countOfAtoms2(String formula) {
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        for (String name: count.keySet()) {
            ans.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1) {
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> count = new TreeMap();
        while (i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry: parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i;
                i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))){
            i++;
        }
        if (iStart < i) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key: count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }

        public String countOfAtoms(String formula) {
            int N = formula.length();
            Stack<Map<String, Integer>> stack = new Stack();
            stack.push(new TreeMap());

            for (int i = 0; i < N;) {
                if (formula.charAt(i) == '(') {
                    stack.push(new TreeMap());
                    i++;
                } else if (formula.charAt(i) == ')') {
                    Map<String, Integer> top = stack.pop();
                    i++;
                    int iStart = i, multiplicity = 1;
                    while (i < N && Character.isDigit(formula.charAt(i))){
                        i++;
                    }
                    if (i > iStart){
                        multiplicity = Integer.parseInt(formula.substring(iStart, i));
                    }
                    for (String c: top.keySet()) {
                        int v = top.get(c);
                        stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                    }
                } else {
                    int iStart = i++;
                    while (i < N && Character.isLowerCase(formula.charAt(i))) {
                        i++;
                    }
                    String name = formula.substring(iStart, i);
                    iStart = i;
                    while (i < N && Character.isDigit(formula.charAt(i))){
                        i++;
                    }
                    int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
                }
            }

            StringBuilder ans = new StringBuilder();
            for (String name: stack.peek().keySet()) {
                ans.append(name);
                int multiplicity = stack.peek().get(name);
                if (multiplicity > 1) ans.append("" + multiplicity);
            }
            return new String(ans);
    }

//    public static void main(String[] args) {
//        Solution soluiton = new Solution();
//        String s = soluiton.countOfAtoms2("K4(ON(SO3)2)2");
//        System.out.println(s);
//    }
public boolean is(int n){
    boolean flag=true;         //先假设都是质数
    int j=(int)Math.sqrt(n);   //令j等于i的平方根
    for(int i=3;i<=j;i++)       //从3开始到j遍历，遍历到j就行了，过了就重复了
        if(n%i==0)              //如果i能被n整除，说明n不是质数，所以令flag=false
            flag=false;
    return flag;       //返回判断值
}
    public static void main(String[] args){
        Solution h = new Solution();
        int N=1000000;
        System.out.println(2);  //2也是质数
        for(int i=3;i<N;i=i+2){
            //从3开始遍历，到10000，等差为2方便跳过偶数
            if(h.is(i)){
                //判断是质数就输出
                System.out.println(i);
            }
        }
    }
}

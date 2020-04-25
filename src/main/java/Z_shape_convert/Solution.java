package Z_shape_convert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

class Solution {
public String convert(  String s, int numRows) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[100];
        int len = numRows+numRows-2;
        for(int i =0;i<numRows;i++){
        for(int j =0;j<numRows;j++){
        if(i==0){
        newChars[j] = chars[j];
        }
        newChars[i+len*j] = chars[(i+j)*numRows+numRows-2];
        }
        }


        return String.valueOf(newChars);
    }


    public String answer(String s,int numRows){
        char[] chars = s.toCharArray();
        List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("consumers");
            }
        });

        strings.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s +s ;
            }
        });
        return null;



    }
  public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.convert("ABCDEFGHIJK",3));
        int size = 5;
      System.out.println(size << 1);
    }
}



package univ.lecture;
import java.util.Stack;
/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
    public int calculate(String exp) {
    	double a, b;
        String temp = new String();
        Stack stack = new Stack();
        for (int i = 0; i < postfix.length(); i++) {
           switch (postfix.charAt(i)) { // 숫자가 나올 때마다 temp에 이어붙임
           case '0':
           case '1':
           case '2':
           case '3':
           case '4':
           case '5':
           case '6':
           case '7':
           case '8':
           case '9':
           case '.':
              temp = temp.concat(postfix.charAt(i) + "");
              break;
           }
        }

        return (double) stack.pop();    }
}

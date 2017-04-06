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
			case ' ': // 공백이 나오면 stack에 temp를 double형으로 push하고 temp를 새로 선언하여 비움
				if (!temp.isEmpty()) // temp가 비어있지 않을 때만 실행
				{
					stack.push(new Double(temp));
					temp = new String();
				}
				break;
			case '+': // +가 나오면 double형으로 두 번째 pop한 것 + 첫 번째 pop한 것 을 하여 결과를
				// push
				a = (double) stack.pop();
				b = (double) stack.pop();
				stack.push(b + a);
				break;
			case '-': // -가 나오면 double형으로 두 번째 pop한 것 - 첫 번째 pop한 것 을 하여 결과를
				// push
				a = (double) stack.pop();
				b = (double) stack.pop();
				stack.push(b - a);
				break;


			}
		}

		return (double) stack.pop();    }
}

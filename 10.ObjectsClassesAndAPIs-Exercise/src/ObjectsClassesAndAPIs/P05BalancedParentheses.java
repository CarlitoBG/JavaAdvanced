package ObjectsClassesAndAPIs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] sequence = scanner.nextLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        boolean result = true;

        for (char current : sequence) {
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }

            if(current == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    result = false;
                }
            }else if (current == '}'){
                if (stack.isEmpty() || stack.pop() != '{'){
                    result = false;
                }
            }else if (current == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    result = false;
                }
            }
        }

        if (result){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
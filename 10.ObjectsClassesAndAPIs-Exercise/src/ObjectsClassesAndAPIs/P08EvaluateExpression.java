package ObjectsClassesAndAPIs;

import java.util.*;

public class P08EvaluateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        ArrayDeque<String> operators = new ArrayDeque<>();  //stack
        ArrayDeque<String> expression = new ArrayDeque<>(); //deque
        Map<String, Integer> priorities = new HashMap<>();

        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        for (String anInput : input) {
            try {
                double num = Double.parseDouble(anInput);
                expression.addLast(anInput);
            } catch (Exception e) {
                if (Character.isLetter(anInput.charAt(0))) {
                    expression.addLast(anInput);
                } else {
                    switch (anInput) {
                        case "(":
                            operators.push(anInput);
                            break;
                        case ")":
                            String symbol = operators.pop();
                            while (!symbol.equals("(")) {
                                expression.addLast(symbol);
                                symbol = operators.pop();
                            }
                            break;
                        default:
                            while (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(anInput)) {
                                expression.addLast(operators.pop());
                            }
                            operators.push(anInput);
                            break;
                    }
                }
            }
        }

        while (!operators.isEmpty()) {
            expression.addLast(operators.pop());
        }

        evaluateExpression(expression);
    }

    private static void evaluateExpression(ArrayDeque<String> expression) {
        double result = 0.0;
        Deque<Double> operands = new ArrayDeque<>();

        for (String str : expression) {
            try {
                double num = Double.parseDouble(str);
                operands.push(num);
            } catch (Exception e) {
                result = 0.0;
                double operand1;
                double operand2;
                switch (str.charAt(0)) {
                    case '+':
                        operand2 = operands.pop();
                        operand1 = operands.pop();
                        result = operand1 + operand2;
                        operands.push(result);
                        break;
                    case '-':
                        operand2 = operands.pop();
                        operand1 = operands.pop();
                        result = operand1 - operand2;
                        operands.push(result);
                        break;
                    case '*':
                        operand2 = operands.pop();
                        operand1 = operands.pop();
                        result = operand1 * operand2;
                        operands.push(result);
                        break;
                    case '/':
                        operand2 = operands.pop();
                        operand1 = operands.pop();
                        result = operand1 / operand2;
                        operands.push(result);
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.printf("%.2f", result);
    }
}
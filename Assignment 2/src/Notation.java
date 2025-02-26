import java.util.*;

public class Notation {

    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        MyQueue<Character> outputQueue = new MyQueue<>();
        MyStack<Character> operatorStack = new MyStack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                outputQueue.enqueue(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.top() != '(') {
                    outputQueue.enqueue(operatorStack.pop());
                }
                if (operatorStack.isEmpty() || operatorStack.pop() != '(') {
                    throw new InvalidNotationFormatException();
                }
            } else if ("+-*/".indexOf(ch) >= 0) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.top()) >= precedence(ch)) {
                    outputQueue.enqueue(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            char op = operatorStack.pop();
            if (op == '(') throw new InvalidNotationFormatException();
            outputQueue.enqueue(op);
        }

        return outputQueue.toString();
    }

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> stack = new MyStack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.toString(ch));
            } else if ("+-*/".indexOf(ch) >= 0) {
                if (stack.size() < 2) throw new InvalidNotationFormatException();
                String right = stack.pop();
                String left = stack.pop();
                stack.push("(" + left + ch + right + ")");
            }
        }

        if (stack.size() != 1) throw new InvalidNotationFormatException();
        return stack.pop();
    }

    public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
        MyStack<Double> stack = new MyStack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push((double) Character.getNumericValue(ch));
            } else if ("+-*/".indexOf(ch) >= 0) {
                if (stack.size() < 2) throw new InvalidNotationFormatException();
                double right = stack.pop();
                double left = stack.pop();

                switch (ch) {
                    case '+': stack.push(left + right); break;
                    case '-': stack.push(left - right); break;
                    case '*': stack.push(left * right); break;
                    case '/': stack.push(left / right); break;
                }
            }
        }

        if (stack.size() != 1) throw new InvalidNotationFormatException();
        return stack.pop();
    }

    private static int precedence(char operator) {
        return (operator == '+' || operator == '-') ? 1 : 2;
    }
}

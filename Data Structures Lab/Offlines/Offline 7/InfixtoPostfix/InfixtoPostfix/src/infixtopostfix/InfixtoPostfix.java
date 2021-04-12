package infixtopostfix;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class InfixtoPostfix {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileReader fin = null;
        Scanner input;
        String exp = null;
        try {
            fin = new FileReader("example.txt");
            input = new Scanner(fin);
            while (input.hasNext()) {
                exp = input.next();
            }
            System.out.println("Infix: " + exp);
        } finally {
            fin.close();
        }
        System.out.println("Postfix: " + infixToPostfix(exp));
    }
}

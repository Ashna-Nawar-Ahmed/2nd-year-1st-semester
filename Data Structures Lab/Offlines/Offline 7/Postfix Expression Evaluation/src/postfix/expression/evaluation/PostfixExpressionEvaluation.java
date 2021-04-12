package postfix.expression.evaluation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixExpressionEvaluation {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fin = null;
        Scanner input;
        char[] postfix = null;
        String s = null;
        try {
            fin = new FileReader("input.txt");
            input = new Scanner(fin);
            while (input.hasNext()) {
                s = input.next();
            }
            if (s != null) {
                postfix = s.toCharArray();
            }
            System.out.println("Postfix Notation:");
            for (int i = 0; i < postfix.length; i++) {
                System.out.print(postfix[i]);
            }
            System.out.println("");
        } finally {
            fin.close();
        }
        Evaluator e = new Evaluator(postfix);
        e.Evaluate(postfix);
        System.out.println("Evaluation Result:" + (int) (e.s.peek() - '0'));
    }
}

class Evaluator {

    char E[] = null;
    int val = 0;
    Stack<Character> s = new <Character>Stack();

    Evaluator(char[] E) {
        this.E = E;
    }

    void Evaluate(char[] postfix) {
        for (int i = 0; i < E.length; i++) {
            if (Character.isDigit(E[i])) {
                s.push(E[i]);
            } else if (E[i] == '+' || E[i] == '-' || E[i] == '*' || E[i] == '/') {
                int B = (int) s.pop() - '0';
                int A = (int) s.pop() - '0';
                switch (E[i]) {
                    case '+':
                        val = A + B;
                        break;
                    case '-':
                        val = A - B;
                        break;
                    case '*':
                        val = A * B;
                        break;
                    case '/':
                        val = A / B;
                        break;
                }
                s.push((char) (val + '0'));
            }
        }
    }
}

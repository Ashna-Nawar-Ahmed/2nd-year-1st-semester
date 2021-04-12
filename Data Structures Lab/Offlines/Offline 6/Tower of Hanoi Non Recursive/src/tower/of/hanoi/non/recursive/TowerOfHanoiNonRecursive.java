package tower.of.hanoi.non.recursive;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
public class TowerOfHanoiNonRecursive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter number of disks:");
        if (input.hasNextInt()) {
            n = input.nextInt();
        }
        Hanoi h = new Hanoi();
        int moves=h.nonRecursive(n, 1, 2, 3);
        System.out.println("Number of moves: "+moves);
    }
}
class Hanoi {

    Stack<Integer> st = new <Integer> Stack();
    int n, i, j, k,moves=0;
    int nonRecursive(int n, int i, int j, int k) {
        st.push(k);
        st.push(j);
        st.push(i);
        st.push(n);
        while (st.empty() == false) {
            try {
                n = st.pop();
                i = st.pop();
                j = st.pop();
                k = st.pop();
            } catch (EmptyStackException e) {
                System.out.println("empty stack");
            }
            if (n == 1) {
                System.out.println("Move top disk from pole " + i + " pole " + k);
                moves++;
            } else {
                st.push(k);
                st.push(i);
                st.push(j);
                st.push(n - 1);

                st.push(k);
                st.push(j);
                st.push(i);
                st.push(1);

                st.push(j);
                st.push(k);
                st.push(i);
                st.push(n - 1);
            }
        }
        return moves;
    }
}

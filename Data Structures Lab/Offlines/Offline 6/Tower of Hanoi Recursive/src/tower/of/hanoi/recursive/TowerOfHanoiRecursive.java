package tower.of.hanoi.recursive;
import java.util.*;
public class TowerOfHanoiRecursive {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=0;
        System.out.println("Enter number of disks:");
        if(input.hasNextInt())
            n=input.nextInt();
        Hanoi h=new Hanoi();
        int moves=h.recursiveHanoi(n, 1, 2, 3);
        System.out.println("Number of moves: "+moves);
    }
}
class Hanoi {
    int moves=0;
    int recursiveHanoi(int n, int i, int j, int k) {
        
        if (n == 1) {
            System.out.println("Move disk " + n + " from pole " + i + " to pole " + k);
            moves++;
        } 
        else {
            recursiveHanoi(n - 1, i, k, j);
            System.out.println("Move disk " + n + " from pole " + i + " to pole " + k);
            moves++;
            recursiveHanoi(n - 1, j, i, k);
        }
        return moves;
    }
    
}

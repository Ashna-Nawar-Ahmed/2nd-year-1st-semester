/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing.inserrtion.search;

/**
 *
 * @author Ashna Ahmed
 */
public class HashingInserrtionSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ar[] = {1, 15, 2, 28, 39, 4};
        Hash h1 = new Hash(ar);
        int arr[] = h1.table();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        if(h1.search(15))
            System.out.println("Found");
        
    }

}

class Hash {

    int ar[];

    Hash(int ar[]) {
        this.ar = ar;
    }
    int m = ar.length;
    int T[] = {-1, -1, -1, -1, -1, -1, -1, -1};

    int h(int z) {
        return z % m;
    }

    void linearProbing(int z) {
        int n = 0;
        int i = h(z);
        boolean found = false;
        while (T[i] == -1 && !found) {
            if (T[i] == z) {
                found = true;
            } else {
                i = (i + 1) % m;
            }
        }
        if (!found) {
            if (n == m - 1) {
                System.out.println("Overflow");
            } else {
                T[i] = z;
                n++;
            }
        }
    }

    boolean search(int val) {
        boolean found = false;
        int ind ,ini;
        ind =ini= val % m;
        if (val == T[ind]) {
            found = true;
            
        } else {
            while (!found) {
                ind++;
                if (val == T[ind]) {
                    found = true;
                    break;
                }
                if(ind==T.length)
                    ind=0;
                if(ind==ini)
                    System.out.println("Not found");
            }
        }
        return found;
    }

    int[] table() {
        for (int i = 0; i < ar.length; i++) {
            linearProbing(ar[i]);
        }
        return T;
    }

}

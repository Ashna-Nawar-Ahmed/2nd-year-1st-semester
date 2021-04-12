package hashing.offline;

import java.util.Scanner;

public class HashingOffline {

    static String[] toInsert = {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"};
    static String[] words = new String[8];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter a word:");
            words[i] = scan.next();
        }
        linearProbing();

        for (int i = 0; i < 9; i++) {
            if (toInsert[i].equalsIgnoreCase("-1")) {
                System.out.println("No Words Inserted at " + i);
            } else {
                System.out.println("Word at " + i + " is " + toInsert[i]);
            }
        }
        System.out.println("Enter word to look for:");
        String word=null;
        if (scan.hasNext()) {
            word = scan.next();
        }
        int x=Search(word);
        if(x!=-1)
            System.out.println(word+ " was found at "+x);
        else System.out.println("Not found");
    }

    public static int hashValue(String word) {
        int hashingValue = 0;
        for (int i = 0; i < word.length(); i++) {
            hashingValue += ((int) word.charAt(i)) - 96;
        }
        return hashingValue % 9;
    }

    static void linearProbing() {
        for (int k = 0; k < 8; k++) {
            String z = words[k];
            int i = hashValue(z);
            boolean found = false;
            while (!toInsert[i].equalsIgnoreCase("-1") && !found) {
                if (toInsert[i].equalsIgnoreCase(z)) {
                    found = true;
                } else {
                    i = (i + 1) % 9;
                }
            }
            if (!found) {
                toInsert[i] = z;
            }
        }
    }

    static int Search(String word) {
        int pos = -1;
        for (int k = 0; k < 8; k++) {
            if (toInsert[k].equals(word)) {
                pos = k;
            }
        }
        return pos;

    }
}

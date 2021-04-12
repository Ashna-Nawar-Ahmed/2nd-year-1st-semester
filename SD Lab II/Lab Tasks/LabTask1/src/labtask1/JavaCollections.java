/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labtask1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author student
 */
public class JavaCollections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Student s1 = new Student ("Kamal", 24);
        Student s2 = new Student ("Jamal", 20);
        Student s3 = new Student ("Abul", 24);
        
        ArrayList <Student> al = new ArrayList <Student>();
        
        al.add(s1);
        al.add(s2);
        al.add(s3);
        
        Collections.sort(al);
        Iterator itr = al.iterator();
        while(itr.hasNext())
        {
            Student st = (Student) itr.next();
            System.out.println(st.name + "  " + st.ID);
        }
        
    }
    
}

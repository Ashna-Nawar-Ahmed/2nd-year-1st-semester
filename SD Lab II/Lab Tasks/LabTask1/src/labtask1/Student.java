/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labtask1;

/**
 *
 * @author student
 */
public class Student implements Comparable <Student>{
    
    String name;
    int ID;
    
    public Student(String name, int ID)
    {
    
        this.name = name;
        this.ID = ID;

    }

    @Override
    public int compareTo(Student st) {
            if(ID==st.ID)
                return 0;
            else if (ID>st.ID)
                return 1;
            else 
                return -1;

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}



package funjavaprojects;
import java.util.*;

/**
 * Step1Main : Tests the 1st stage of LibraryBook class
 * Used to verify that you can create LibraryBook objects
 * using different constructors. Check that methods are working
 * correctly, especially the toString method. 
 * 
 * @author Alberto Fernandez Saucedo
 */
public class Step1Main {
    public static void main(String[] args){
        GregorianCalendar dueDate;
        LibraryBook book1, book2, book3, book4;
        
        dueDate = new GregorianCalendar(2017, Calendar.MARCH, 14);
        book1 = new LibraryBook(dueDate);
        
        dueDate = new GregorianCalendar(2017, Calendar.MARCH, 13);
        book2 = new LibraryBook(dueDate, 0.75);
        book2.setTitle("OOP with Java");
        
        dueDate = new GregorianCalendar(2017, Calendar.APRIL, 2);
        book3 = new LibraryBook(dueDate, 1.00, 100.00);
        book3.setTitle("Data Structures with Java");
        
        
        dueDate = new GregorianCalendar(2017, Calendar.MARCH, 14);
        book4 = new LibraryBook(dueDate, 1.50, 230.00, "Java and Me");
        
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
    }
}

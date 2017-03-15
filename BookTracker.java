
package funjavaprojects;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class BookTracker {
    ArrayList<LibraryBook> list = new ArrayList();
    
    public BookTracker(){
        
    }
    
    public void add(LibraryBook book){
        list.add(book);
    }
    
    public double getCharge(){
        return 1.00;
    }
    
    public double getCharge(GregorianCalendar returnDate){
      
        return 1.00;
    }
    
    public String getList(){
        
        String str = "";
        
        for (LibraryBook list1 : list) {
            str += list1 + "\n";
        }
        return str;
    }
}


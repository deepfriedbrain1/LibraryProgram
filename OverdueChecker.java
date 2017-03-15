
package funjavaprojects;
import java.util.*;
/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class OverdueChecker {
    
    private static enum Response {YES, NO}
    
    private static final String DATE_SEPARATOR = "/";
    
    private Scanner scanner;
    
    private BookTracker bookTracker;
    
    // Constructors
    
    public OverdueChecker(){
        scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        
        bookTracker = new BookTracker();
    }
    
    // Main method
    public static void main(String[] args){
        
        OverdueChecker checker = new OverdueChecker();
        checker.start();
    }
    
    // Public Methods
    public void start(){
        
        GregorianCalendar returnDate;
        
        String table;
        double charge;
        Response response;
        
        inputBooks();
        
        table = bookTracker.getList();
        System.out.println(table);
        
        System.out.println("\nNow check the over due charges...\n");
        
        // try different return dates
        do{
            // read return date
            returnDate = readDate("\nReturn Date: ");
            
            charge = bookTracker.getCharge(returnDate);
            
            displayTotalCharge(charge);
            
            response = prompt("\nRun Again (yes/no)? ");
            
        } while (response == Response.YES);
        
        System.out.println("\n\nThank you for using Library Overdue Checker");
        
    }
    
    // Private Methods
    private LibraryBook createBook(String title, double chargePerDay,
                                                 double maxCharge,
                                                 GregorianCalendar dueDate){
        if (dueDate == null){
            dueDate = new GregorianCalendar(); // set today as due date
        }
        LibraryBook book = new LibraryBook(dueDate);
        
        if (title.length() > 0){
            book.setTitle(title);
        }
        
        if (chargePerDay > 0.0){
            book.setChargePerDay(chargePerDay);
        }
        
        if (maxCharge > 0.0){
            book.setMaximumCharge(maxCharge);
        }
        
        return book;  
    }
    
    private void display(String text){
        System.out.print(text);
    }
    
    private void displayTotalCharge(double charge){
        System.out.format("\nTOTAL CHARGE:\t $%8.2f" , charge);
    }
    
    private void inputBooks(){
        
        double chargePerDay, maxCharge;
        String title;
        
        GregorianCalendar dueDate;
        LibraryBook book;
        
        // Keeps on reading input from a console 
        // until stopped by the end user
        
        while (isContinue()){
            System.out.println("\n");
            title        = readString("Title         : ");
            chargePerDay = readDouble("Charge per day: ");
            maxCharge    = readDouble("Maximum charge: ");
            dueDate      = readDate  ("Due Date      : ");
            
            book = createBook(title, chargePerDay, maxCharge, dueDate);
            
            bookTracker.add(book);
        }
    }
    
    private boolean isContinue(){
        
        Response response = prompt("\nMore books to enter (y/n)?");
            
        return (response == Response.YES);
    }
    
    private Response prompt(String question){
        
        String input;
        
        Response response = Response.NO;
        
        System.out.print(question + " (Yes - y; No - n): ");
        input = scanner.next();
        
        if (input.equals("Y") || input.equals("y")){
            response = Response.YES;
        }
        
        return response;
    }
    
    private double readDouble(String prompt){
        display(prompt);
        
        return scanner.nextDouble();
    }
    
    private GregorianCalendar readDate(String prompt){
        
        GregorianCalendar calendar;
        
        String yearStr, monthStr, dayStr, line;
        
        int sep1, sep2;
        
        display(prompt);
        
        line = scanner.next();
        
        if (line.length() == 0){
            calendar = null;
        } 
        else {
            sep1 = line.indexOf(DATE_SEPARATOR);
            sep2 = line.lastIndexOf(DATE_SEPARATOR);
            
            monthStr = line.substring(0, sep1);
            dayStr = line.substring(sep1 + 1, sep2);
            yearStr = line.substring(sep2 + 1, line.length());
            
            calendar = new GregorianCalendar(Integer.parseInt(yearStr),
                                             Integer.parseInt(monthStr)-1,
                                             Integer.parseInt(dayStr));
        }
        
        return calendar;
    }
    
    private String readString(String prompt){
        
        display(prompt);
        
        return scanner.next();
    }
    
}

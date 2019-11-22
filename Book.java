
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private int CatalougeNumber;
    private String author;
    private String title;
    public Book(int CatalogueNumber, String title, String author)
    {
        this.CatalougeNumber = CatalougeNumber;
        this.author = author;
        this.title = title;
    }
    public int getCatalogueNumber(){
        return this.CatalougeNumber;
    }
    public void attachLoan(){
        Loan loan = new Loan();
        loan.setBook(this);
    }    
}
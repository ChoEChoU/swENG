
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (Iteration#1)
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
    public void attachLoan(Loan loan){
        loan.setBook(this);
    }
    public void detachLoan(Loan loan){
        loan.setBook(null);
    }
    public void display(){
        this.toString();
    }
}
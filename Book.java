
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
    public void display(){}
    public void attachLoan(){}
    public void detachLoan(){}
    public void getLoan(){}
    public int compareTo(){}
    public boolean equals(){}
}

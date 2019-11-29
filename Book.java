
/**
 * Write a description of class Book here.
 *
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재)
 * @version (Iteration#1)
 */
public class Book
{
    private int CatalougeNumber;
    private String author;
    private String title;

    private Loan loan = null;

    public Book(int CatalogueNumber, String title, String author)
    {
        this.CatalougeNumber = CatalougeNumber;
        this.author = author;
        this.title = title;
    }

    public int getCatalougeNumber(){
        return this.CatalougeNumber;
    }

    public void attachLoan(Loan loan){

        loan.attachBook(this);//loan객체에 book을 배당
        this.loan = loan;

    }

    public void detachLoan(Loan loan){
        loan.attachBook(null);//loan객체에 book을 배당해제
        this.loan = null;

    }

    public int compareTO(Book book){
        if (book.getCatalougeNumber() == this.CatalougeNumber){
            return 0;
        }
        else if(this.CatalougeNumber > book.getCatalougeNumber()){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    public Loan getLoan(){
        return loan;
    }
    
    public String toString(){
        return CatalougeNumber + title + author;
    }
}
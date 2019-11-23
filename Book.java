
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
        loan.setBook(this);//loan객체에 book을 배당
    }

    public void detachLoan(Loan loan){
        loan.setBook(null);//loan객체에 book을 배당해제
    }

    public void display(){
        this.toString(); //대출 중 or 대출가능 책들을 보여주기 위한 메소드
    }
}
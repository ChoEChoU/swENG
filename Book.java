
/**
 * Write a description of class Book here.
 *
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재)
 * @version (Iteration#1)
 */
public class Book implements Comparable<Book>
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
        loan.detachBook();//loan객체에 book을 배당해제
        this.loan = null;

    }

    public int compareTo(Book book){
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
    
    public boolean checkLoan(){
        if(this.loan == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public String toString(){
        return " 카탈로그번호 "+CatalougeNumber+" 제목: "+ title+" 저자" + author;
    }
}
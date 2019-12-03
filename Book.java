
/**
 * Book 클래스.
 *
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재)
 * @version (Iteration#3)
 */
public class Book implements Comparable<Book>
{
    private int CatalogueNumber;
    private String author;
    private String title;
    private Loan loan = null;

    public Book(int CatalogueNumber, String title, String author)
    {
        this.CatalogueNumber = CatalogueNumber;
        this.author = author;
        this.title = title;
    }

    public int getCatalogueNumber(){
        return this.CatalogueNumber;
    }

    public void attachLoan(Loan loan){
        loan.attachBook(this);//대출 객체에 해당 도서를 배당
        this.loan = loan;
    }

    public void detachLoan(Loan loan){
        loan.detachBook();//대출 객체에 해당 도서를  배당해제
        this.loan = null;
    }

    public int compareTo(Book book){
        if (book.getCatalogueNumber() == this.CatalogueNumber){
            return 0;
        }
        else if(this.CatalogueNumber > book.getCatalogueNumber()){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    public boolean checkLoan(){
        //해당 도서의 대출 여부를 파악한다. 
        if(this.loan == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public String toString(){
        return " 카탈로그번호: "+CatalogueNumber+" 제목: "+ title+" 저자" + author + "\n" ;
    }
}
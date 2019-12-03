import java.util.*;
import java.text.*;
/**
 * Loan 클래스.
 * 도서를 대출하며 대출 객체에 해당 이용자와 해당도서를 배당한다.
 * 도서를 반납하면 대출 객체에 배당 되어있는 이용자와 도서를 배당 해제 한다.
 * 
 * @author(2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#3)
 */
public class Loan
{
    private Borrower borrower;
    private Book book;    
    private String lendDate;
    private String returnDate;

    public Loan(){
        this.lendDate = lendDate();
        this.returnDate = returnDate();
    }

    public void attachBook(Book book){
        this.book = book;
    }

    public void attachBorrower(Borrower borrower){
        this.borrower = borrower;
    }

    public Book getBook(){
        return book;
    }

    public Borrower getBorrower(){
        return this.borrower;
    }

    public void detachBook() {
        this.book = null;
    }

    public void detachBorrower() {
        this.borrower = null;
    }

    public String returnDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, +14);
        // 도서의 대출 기간을 14일로 설정
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        //날짜 포맷 설정
        Date time = calendar.getTime();
        String returnDate = format.format(time);
        return returnDate;
    }

    public String lendDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date();
        String lendDate = format.format(time);
        return lendDate;
    }
    
    public String getReturnDate() {
        return this.returnDate;
    }
}
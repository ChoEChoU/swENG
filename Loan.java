import java.util.*;
import java.text.*;
/**
 * 여기에 Loan 클래스 설명을 작성하십시오.
 * 
 * @author(2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#1)
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
        return this.book;
    }

    public Borrower getBorrower(){
        return borrower;
        //this.borrower??
    }

    public void detachBook() {
        this.book = null;
    }

    public void detachBorrower() {
        this.borrower = null;
    }

    public String returnDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, +14); // 대출 기간을 14일로 설정
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //날짜 포맷 설정
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
/**
 * 여기에 Loan 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (Iteration#1)
 */
public class Loan
{
    private Borrower borrower;
    private Book book;
    public Loan(){
       
    }
    
    public void setBook(Book book){
        this.book = book;
    }
        
    public void setBorrower(Borrower borrower){
        this.borrower = borrower;
    }
    
    public Book getBook(){
        return this.book;
    }
    
    public Borrower getBorrower(){
        return this.borrower;
    }
}
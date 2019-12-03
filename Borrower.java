/**
 * Borrower 클래스.
 * 
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#3)
 */
public class Borrower
{
    private String name;  
    private Loan loan = null;
    
    public Borrower(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }    

    public void attachLoan(Loan loan){
        loan.attachBorrower(this); //대출 객체에 해당 이용자를 배당
    }    

    public void detachLoan(Loan loan){
        loan.detachBorrower();//대출 객체에서 해당 이용자를 배당 해제
        this.loan = null;
    }
}
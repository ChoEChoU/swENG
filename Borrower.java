/**
 * 여기에 Borrower 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (Iteration#1)
 */
public class Borrower
{
    private String name;
    public Borrower(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    
    public void attachLoan(Loan loan){
        loan.setBorrower(this);
    }
    
    public void detachLoan(Loan loan){
        loan.setBorrower(null);
    }
}
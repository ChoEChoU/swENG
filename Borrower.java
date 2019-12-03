/**
 * 여기에 Borrower 클래스 설명을 작성하십시오.
 * 
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#1)
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
        loan.attachBorrower(this); //loan객체에 borrower를 배당
    }    

    public void detachLoan(Loan loan){
        loan.detachBorrower();//loan객체에 borrower를 배당해제
        this.loan = null; //detach 후 loan 을 null로 설정
    }
    
    
}
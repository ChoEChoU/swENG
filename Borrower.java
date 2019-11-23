/**
 * 여기에 Borrower 클래스 설명을 작성하십시오.
 * 
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
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
        loan.setBorrower(this); //loan객체에 borrower를 배당
    }    

    public void detachLoan(Loan loan){
        loan.setBorrower(null); //loan객체에 borrower를 배당해제
    }
}
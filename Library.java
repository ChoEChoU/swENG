import java.uitl.HashSet;
/**
 * 여기에 Library 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Library
{
    private String name; // 도서관은 하나의 이름을 가진다.
    private HashSet <Borrower> registeredBorrowers;
    public Library(String name){
        this.name = name;
        registeredBorrowers = new HashSet <Borrower> ();
    }
    public void registerOneBorrower(String name){ // 동명이인을 확인한다, new borrower(name)
        Borrower borrower = new Borrower(name);
        registeredBorrowers.add(borrower);
    }
    public void registerOneBook(){}
    public void displayBooksForLoan(){}
    public void displayBooksOnLoan(){}
    public void LendOneBook(){}
    public void ReturnOneBook(){}
}

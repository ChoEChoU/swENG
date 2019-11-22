import java.util.*;
/**
 * 여기에 Library 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Library
{
    private String name; // 도서관은 하나의 이름을 가진다.
    private TreeSet<Book> registeredBooks;
    private HashSet<Borrower> registeredBorrowers;
    private HashSet<Loan> loanedbooks;
    public Library(String name){
        this.name = name;
        registeredBorrowers = new HashSet<Borrower>();
    }

    public void registerOneBorrower(String name){ // 동명이인을 확인한다, new borrower(name)
        Borrower borrower = new Borrower(name);
        registeredBorrowers.add(borrower);
    }

    public void registerOneBook(int CatalogueNumber, String title, String author){
        Book book = new Book(CatalogueNumber,title,author);
        registeredBooks.add(book);
    }

    public void displayBooksForLoan(){}

    public void displayBooksOnLoan(){}

    public void LendOneBook(int CatalogueNumber,String Name)
    {
        Book book;
        Borrower borrower;
        Iterator iterbook = registeredBooks.iterator();
        
        while(iterbook.hasNext()){
            Book nextBook = (Book)iterbook.next();
            int bookCatalogueNumber = nextBook.getCatalogueNumber();
            if(CatalogueNumber == bookCatalogueNumber){
                //Iterator iterborrower = registeredBorrowers.iterator();
                book = nextBook;
            }
        }

        Iterator iterBorrower = registeredBorrowers.iterator();
        while (iterBorrower.hasNext()){
            Borrower nextBorrower = (Borrower)iterBorrower.next();
            String borrowerName = nextBorrower.getName();
            if(Name == borrowerName){
                //Iterator iterborrower = registeredBorrowers.iterator();
                borrower = nextBorrower;
            }
        }
        
        
        
        
    }

    public void ReturnOneBook(){}
}
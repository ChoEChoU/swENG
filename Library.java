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
    private HashSet<Loan> loans;
    public Library(String name){
        this.name = name;
        registeredBorrowers = new HashSet<Borrower>();
    }

    public void registerOneBorrower(String name){ // 동명이인을 확인한다, new borrower(name)
        Iterator iterBorrower = registeredBorrowers.iterator();
        while (iterBorrower.hasNext()){
            Borrower nextBorrower = (Borrower)iterBorrower.next();
            if (nextBorrower.getName() == name){
                System.out.println("이미 등록되있는 이용자입니다.");
            }
            else {
                Borrower borrower = new Borrower(name);
                registeredBorrowers.add(borrower);
            }
        }
    }

    public void registerOneBook(int CatalogueNumber, String title, String author){
        Iterator iterBook = registeredBooks.iterator();
        while (iterBook.hasNext()){
            Book nextBook = (Book)iterBook.next();
            if(nextBook.getCatalogueNumber() == CatalogueNumber){
                System.out.println("이미 등록되있는 책입니다.");
            }
            else {
                Book book = new Book(CatalogueNumber,title,author);
                registeredBooks.add(book);
            }
        }
    }

    public void displayBooksForLoan(){
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book nextBook = (Book)iterBook.next();
            Iterator iterLoan = loans.iterator();
            while(iterLoan.hasNext()){
                Loan nextLoan = (Loan)iterLoan.next();
                if(nextLoan.getBook().equals(nextBook)){
                }
                else{
                    nextBook.display();
                }
            }
        }
    }

    public void displayBooksOnLoan(){
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book nextBook = (Book)iterBook.next();
            Iterator iterLoan = loans.iterator();
            while(iterLoan.hasNext()){
                Loan nextLoan = (Loan)iterLoan.next();
                if(nextLoan.getBook().equals(nextBook)){
                    nextBook.display();
                }
            }
        }
    }

    public void LendOneBook(int CatalogueNumber,String Name)
    {
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book nextBook = (Book)iterBook.next();
            int bookCatalogueNumber = nextBook.getCatalogueNumber();
            if(CatalogueNumber == bookCatalogueNumber){
                Book book = nextBook;
                Iterator iterBorrower = registeredBorrowers.iterator();
                while (iterBorrower.hasNext()){
                    Borrower nextBorrower = (Borrower)iterBorrower.next();
                    String borrowerName = nextBorrower.getName();
                    if(Name == borrowerName){
                        Borrower borrower = nextBorrower;

                        Loan loan = new Loan();

                        book.attachLoan(loan);
                        borrower.attachLoan(loan);
                        
                        loans.add(loan);
                    }
                }
            }
        }
    }

    public void ReturnOneBook(int CaltalogueNumber){
        Iterator iterLoan = loans.iterator();
        while(iterLoan.hasNext()){
            Loan nextLoan = (Loan)iterLoan.next();
            Iterator iterBook =  registeredBooks.iterator();
            while(iterBook.hasNext()){
                Book nextBook = (Book)iterBook.next();
                if(nextBook.getCatalogueNumber()==CaltalogueNumber){
                    Book book = nextBook;
                    if(book.equals(nextLoan.getBook())){
                        nextLoan.setBook(null);
                        nextLoan.setBorrower(null);
                    }
                }
            }
        }       
    }
}
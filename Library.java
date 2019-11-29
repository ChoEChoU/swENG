import java.util.*;
/**
 * 여기에 Library 클래스 설명을 작성하십시오.
 * 
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#1)
 */
public class Library
{
    private String name; // 도서관은 하나의 이름을 가진다.
    private TreeSet<Book> registeredBooks;
    private HashSet<Borrower> registeredBorrowers;
    private HashMap<Integer, Loan> loans;

    public Library(String name){
        this.name = name;
        registeredBooks = new TreeSet<Book>();
        registeredBorrowers = new HashSet<Borrower>();
        loans = new HashMap<Integer, Loan>();
    }

    public void registerOneBorrower(String Name){ // 동명이인을 확인한다, new borrower(name)
        Borrower newborrower = new Borrower(Name);
        if(registeredBorrowers.contains(newborrower)) {
            System.out.println("이미 등록되있는 이용자입니다.");
            newborrower = null;
        }
        else {
            registeredBorrowers.add(newborrower);
            System.out.println("새로운 이용자를 등록했습니다.");
        }
    }

    public void registerOneBook(int CatalogueNumber, String title, String author){
        Book newbook = new Book(CatalogueNumber, title, author);
        if (registeredBooks.contains(newbook)){
            System.out.println("이미 등록된 책입니다.");
            newbook = null;
        }
        else{
            registeredBooks.add(newbook);
            System.out.println("새로운 책을 등록했습니다.");
        }
    }

    public void displayBooksForLoan(){
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book bookForLoan = (Book)iterBook.next();
            if(bookForLoan.getLoan() == null){
                System.out.println(bookForLoan.toString());
            }
        }
    }

    public void displayBooksOnLoan(){
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book bookOnLoan = (Book)iterBook.next();
            if (bookOnLoan.getLoan() != null){
                System.out.println(bookOnLoan.toString());
            }
        }
    }

    public void LendOneBook(int CatalogueNumber,String Name)
    {
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book book = (Book)iterBook.next();
            if(book.getCatalougeNumber() == CatalogueNumber && loans.get(CatalogueNumber) == null){
                Iterator iterBorrower = registeredBorrowers.iterator();
                while (iterBorrower.hasNext()){
                    Borrower borrower = (Borrower)iterBorrower.next();
                    if(borrower.getName() == Name){
                        Loan loan = new Loan();

                        book.attachLoan(loan);
                        borrower.attachLoan(loan);

                        loans.put(CatalogueNumber, loan);
                    }
                }
            }
        }
    }

    public void ReturnOneBook(int CatalogueNumber){
        Iterator iterBook = registeredBooks.iterator();
        while(iterBook.hasNext()){
            Book book = (Book) iterBook.next();
            if(book.getCatalougeNumber() == CatalogueNumber){
                Loan loan = loans.get(CatalogueNumber);
                loan.getBook().detachLoan(loan);
                loan.getBorrower().detachLoan(loan);
                loans.remove(CatalogueNumber);
            }
        }
    }
}
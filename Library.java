import java.util.*;
/**
 * Library 클래스의 역할
 * 새로운 이용자를 등록하고, 새로운 도서를 등록해준다. 
 * 수장자료를 대출, 반납 해준다.
 * 대출중 인 도서와 대출 가능한 도서를 보여준다.
 * 
 * @author (2018315017 임민택 2018315038 이혜인 2018315039 이윤재) 
 * @version (Iteration#3)
 */
public class Library
{
    private String name; // 도서관은 하나의 이름을 가진다.
    private TreeSet<Book> registeredBooks = new TreeSet<Book>();
    //도서의 카달로그 번호를 오름차순으로 정렬하기위해 TreeSet을 이용한다.
    private HashSet<Borrower> registeredBorrowers = new HashSet<Borrower>();;
    private HashMap<Integer, Loan> loans  = new HashMap<Integer, Loan>();
    //도서의 카달로그 번호(Integer) 를 키 값으로 하여 대출객체(loan)을 쉽게 찾는다.

    public Library(String name){
        this.name = name;
        registeredBooks = new TreeSet<Book>();
        registeredBorrowers = new HashSet<Borrower>();
        loans = new HashMap<Integer, Loan>();
    }

    public Boolean registerOneBorrower(String name){ 
        Borrower findedBorrower = findBorrower(name);
        if (findedBorrower == null) {
            Borrower newBorrower = new Borrower(name);
            registeredBorrowers.add(newBorrower);
            return true;
        }
        return false;
    }

    public Boolean registerOneBook(int CatalogueNumber, String title, String author){
        Book findedBook = findBook(CatalogueNumber);
        if(findedBook == null) {
            Book newbook = new Book(CatalogueNumber, title, author);
            registeredBooks.add(newbook);
            return true;
        }
        return false;
    }

    public String displayBooksForLoan(){
        String result = "";
        Iterator<Book> iterBooks = registeredBooks.iterator();
        while(iterBooks.hasNext()){
            Book bookForLoan = (Book)iterBooks.next();
            if(bookForLoan.checkLoan() == false){
                result += bookForLoan.toString();
            }
        }
        return result;
    }

    public String displayBooksOnLoan(){
        String result = "";
        Iterator<Book> iterBooks = registeredBooks.iterator();
        while(iterBooks.hasNext()){
            Book bookOnLoan = (Book)iterBooks.next();
            if (bookOnLoan.checkLoan() == true){
                result += bookOnLoan.toString();
            }
        }
        return result;
    }

    public String LendOneBook(int CatalogueNumber,String name)
    {
        Book findedBook = findBook(CatalogueNumber);
        if (findedBook != null) {
            if (findedBook.checkLoan() == false) {
                Borrower findedBorrower = findBorrower(name);
                Loan loan = new Loan();
                findedBook.attachLoan(loan);
                findedBorrower.attachLoan(loan);
                loans.put(CatalogueNumber, loan);
                return "대출이 완료되었습니다." + " 반납일은 " + loan.getReturnDate() + " 입니다."; 
            }
            return "대출에 실패하였습니다.";
        }
        return "대출에 실패하였습니다.";
    }

    public Boolean ReturnOneBook(int CatalogueNumber){
        if (loans.get(CatalogueNumber) != null) {
            Loan loan = loans.get(CatalogueNumber);
            Book findedBook = loan.getBook();
            Borrower findedBorrower = loan.getBorrower();
            findedBook.detachLoan(loan);
            findedBorrower.detachLoan(loan);
            loans.remove(CatalogueNumber);
            return true;
        }
        else{
            return false;
        }
    }

    public Book findBook(int CatalogueNumber){
        //도서의 카달로그 번호가지고 해당 카달로그 번호를 가지고있는 도서를 찾는다.
        Iterator<Book> iterBook = registeredBooks.iterator();
        Book book = null;
        while(iterBook.hasNext()){
            Book nextBook = (Book)iterBook.next();
            if(nextBook.getCatalogueNumber() == CatalogueNumber){
                book = nextBook;
            }
        }
        return book;
    }

    public Borrower findBorrower(String name){
        //이용자의 이름을 가지고 해당 이용자를 찾는다.
        Iterator<Borrower> iterBorrower = registeredBorrowers.iterator();
        Borrower borrower = null;
        while (iterBorrower.hasNext()) {
            Borrower nextBorrower = (Borrower)iterBorrower.next();
            if (nextBorrower.getName().equals(name)){
                borrower = nextBorrower;
            }
        }
        return borrower;
    }
}
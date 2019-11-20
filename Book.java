
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private int CatalougeNumber;
    private String author;
    private String title;
    public Book(int CatalogueNumber, String title, String author)
    {
        this.CatalougeNumber = CatalougeNumber;
        this.author = author;
        this.title = title;
    }
    public void display(){}
    public void attachLoan(){} //대출 시 loan객체에 책을 배당하는 메소드
    public void detachLoan(){} //반납 시 loan객체에 책을 배당해제하는 메소드
    public int compareTo(){}//카달로그 넘버를 비교 하는 메소드
    public boolean equals(){}
}

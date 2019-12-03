import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class MyFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyFrame extends JFrame implements ActionListener 
{
    public MyFrame(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 450);
        this.setLayout(new BorderLayout());
        JPanel mainpanel = new JPanel();
        JButton btn_lend = new JButton("대출");
        JButton btn_return = new JButton("반납");
        JButton btn_newbook = new JButton("신규 도서 등록");
        JButton btn_newborrower = new JButton("신규 이용자 등록");
        JButton btn_displayon = new JButton("대출 가능한 책 조회");
        JButton btn_displayfor = new JButton("대출 중인 책 조회");
        mainpanel.add(btn_lend); 
        mainpanel.add(btn_return); 
        mainpanel.add(btn_newbook); 
        mainpanel.add(btn_newborrower); 
        mainpanel.add(btn_displayon); 
        mainpanel.add(btn_displayfor);
        this.add(mainpanel, BorderLayout.NORTH);
        btn_lend.addActionListener(this); 
        btn_return.addActionListener(this);
        btn_newbook.addActionListener(this);
        btn_newborrower.addActionListener(this);
        btn_displayon.addActionListener(this);
        btn_displayfor.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        JButton btn = (JButton)e.getSource();
        if(btn.getText() == "대출"){
        }
        else if(btn.getText() == "반납"){
        }
        else if(btn.getText() == "신규 도서 등록"){
        }
        else if(btn.getText() == "신규 이용자 등록"){
        }
        else if(btn.getText() == "대출 가능한 책 조회"){
        }
        else if(btn.getText() == "대출 중인 책 조회"){
        }
    }
}
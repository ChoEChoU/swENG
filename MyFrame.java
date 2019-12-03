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
    JPanel secondpanel = new JPanel();
    JTextField name_lend;
    JTextField num_lend;
    JTextField num_return;
    JTextField num_newbook;
    JTextField title_newbook;
    JTextField author_newbook;
    JTextField name_newborrower;
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
        if(btn.getText().equals("대출")){
            secondpanel.removeAll();
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(10,1));
            secondpanel.add(new JLabel("이용자 이름"));
            name_lend = new JTextField();
            secondpanel.add(name_lend);
            secondpanel.add(new JLabel("책의 카달로그 번호"));
            num_lend = new JTextField();
            secondpanel.add(num_lend);
            JButton lendOneBook = new JButton("대출하기");
            secondpanel.add(lendOneBook);  
            lendOneBook.addActionListener(new MyListener());
            this.add(secondpanel,BorderLayout.CENTER);
            secondpanel.revalidate(); 
        }
        else if(btn.getText().equals("반납")){
            secondpanel.removeAll();
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(10,1));
            secondpanel.add(new JLabel("책의 카달로그 번호"));
            num_return = new JTextField();
            secondpanel.add(num_return);
            JButton returnOneBook = new JButton("반납하기");
            secondpanel.add(returnOneBook);
            returnOneBook.addActionListener(new MyListener());
            this.add(secondpanel,BorderLayout.CENTER);
            secondpanel.revalidate(); 
        }
        else if(btn.getText().equals("신규 도서 등록")){
            secondpanel.removeAll();
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(10,1));
            secondpanel.add(new JLabel("책의 카달로그 번호"));
            num_newbook = new JTextField();
            secondpanel.add(num_newbook);
            secondpanel.add(new JLabel("책의 제목"));
            title_newbook = new JTextField();
            secondpanel.add(title_newbook);
            secondpanel.add(new JLabel("책의 저자"));
            author_newbook = new JTextField();
            secondpanel.add(author_newbook);
            JButton registerOneBook = new JButton("도서 등록하기");
            secondpanel.add(registerOneBook);
            registerOneBook.addActionListener(new MyListener());
            this.add(secondpanel,BorderLayout.CENTER);
            secondpanel.revalidate(); 
        }
        else if(btn.getText().equals("신규 이용자 등록")){
            secondpanel.removeAll();
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(10,1));
            secondpanel.add(new JLabel("이용자의 이름"));
            name_newborrower = new JTextField();
            secondpanel.add(name_newborrower);
            JButton registerOneBorrower = new JButton("이용자 등록하기");
            secondpanel.add(registerOneBorrower);
            registerOneBorrower.addActionListener(new MyListener());
            this.add(secondpanel,BorderLayout.CENTER);
            secondpanel.revalidate(); 
        }
        else if(btn.getText().equals("대출 가능한 책 조회")){
            secondpanel.removeAll(); 
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(1,1));
            JTextArea ta_on = new JTextArea();
            ta_on.setText("대출 가능한 책");
            JScrollPane scroll_on = new JScrollPane(ta_on);
            secondpanel.add(scroll_on);
            ta_on.setEnabled(false);
            secondpanel.revalidate(); 
        }
        else if(btn.getText().equals("대출 중인 책 조회")){
            secondpanel.removeAll(); 
            secondpanel.repaint();
            secondpanel.setLayout(new GridLayout(1,1));
            JTextArea ta_for = new JTextArea();
            ta_for.setText("대출 중인 책");
            JScrollPane scroll_for = new JScrollPane(ta_for);
            secondpanel.add(scroll_for);
            ta_for.setEnabled(false);
            secondpanel.revalidate(); 
        }
    }
    class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton bt = (JButton)e.getSource();
            if (bt.getText() == "도서 등록하기"){
                if(num_newbook.getText().equals("")) {
                    secondpanel.add(new JLabel("번호를 입력하세요"));
                    secondpanel.revalidate(); 
                }
                else if (title_newbook.getText().equals("")){
                    secondpanel.add(new JLabel("제목을 입력하세요"));
                    secondpanel.revalidate(); 
                }
                else if(author_newbook.getText().equals("")) {
                    secondpanel.add(new JLabel("저자를 입력하세요"));
                    secondpanel.revalidate(); 
                }				

                else {
                    //도서 등록 성공 시 
                }
            }
            else if (bt.getText() == "이용자 등록하기") {
                if(name_newborrower.getText().equals("")) {
                    secondpanel.add(new JLabel("이름을 입력하세요"));
                    secondpanel.revalidate(); 
                }
                else {
                    //이용자 등록 성공시 
                }
            }
            else if (bt.getText() == "대출하기") {
                if(name_lend.getText().equals("")) {
                    secondpanel.add(new JLabel("이름을 입력하세요"));
                    secondpanel.revalidate(); 
                }
                else if(num_lend.getText().equals("")) {
                    secondpanel.add(new JLabel("번호를 입력하세요"));
                    secondpanel.revalidate(); 					
                }
                else{
                    //대출 성공
                }
            }
            else if (bt.getText() == "반납하기" ) {
                if(num_return.getText().equals("")) {
                    secondpanel.add(new JLabel("번호를 입력하세요"));
                    secondpanel.revalidate(); 
                }
                else{
                    //반납 성공
                }
            }
        }
    }
}
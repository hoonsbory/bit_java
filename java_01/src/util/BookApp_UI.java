package util;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookApp_UI {

	public static void main(String[] args) {

		new UI();
	}
}

class UI extends JFrame implements ActionListener {

	JFrame f1, f2, f3;
	JButton intro, search, add, delete, quit, list;
	Panel p1, p2, p3, p4, p5, p6, p7, p8, p9;
	TextField introduction, searchTitle, insertTitle, insertPrice, deleteISBN;
	TextArea output;

	BookMgr book = new BookMgr();
	Book theBook = new Book();
	
	int count =10;

	UI() {

		super("BookApp for Administrator");

		p1 = new Panel();
		p1.add(intro = new JButton("아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요."));
		add(p1, BorderLayout.PAGE_START);

		add(output = new TextArea(10, 10));
		output.setVisible(true);
		output.setFont(new Font(null, 2, 24));

		
		p2 = new Panel();
		
		GridLayout grid = new GridLayout(1, 5);
		p2.setLayout(grid);
		p2.add(search = new JButton("Search by Title"));
		p2.add(add = new JButton("Add Book"));
		p2.add(delete = new JButton("Delete Book"));
		p2.add(list = new JButton("Print Book List"));
		p2.add(quit = new JButton("Quit"));
		add(p2, BorderLayout.SOUTH);

		intro.addActionListener(this);
		search.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		quit.addActionListener(this);
		
		// search
		p3 = new Panel();
		p3.add(new JLabel("검색할 책 title 입력"));
		p3.add(searchTitle = new TextField(20));
		f1 = new JFrame();
		f1.setVisible(false);
		f1.add(p3, BorderLayout.NORTH);

		// Search
		searchTitle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.append("검색 결과: " + book.searchTitleBook(searchTitle.getText()) +"\n");
				searchTitle.setText("");

			}
		});

		// insert
		f2 = new JFrame();
		f2.setVisible(false);

		GridLayout layout = new GridLayout(2, 2);
		f2.setLayout(layout);

		p7 = new Panel();
		p7.add(new JLabel("등록할 책 title 입력"));
		p7.add(insertTitle = new TextField(20));
		f2.add(p7, BorderLayout.NORTH);

		p4 = new Panel();
		p4.add(new JLabel("등록할 책 price 입력"));
		p4.add(insertPrice = new TextField(20));
		f2.add(p4, BorderLayout.SOUTH);

		// insert
		
		insertTitle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				//theBook =  new Book (insertTitle.getText(), insertPrice.getText());
				output.append(book.addBook(count, new Book(insertTitle.getText(), insertPrice.getText())) + "\n");
				book.addBook(count, new Book (insertTitle.getText(), insertPrice.getText()));
				insertTitle.setText("");
				
				output.append("제목 추가 완료~~\n");
				
			}
		});
		
		
		insertPrice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				book.addBook(count, new Book (insertTitle.getText(), insertPrice.getText()));
				insertPrice.setText("");
				
				output.append("가격 추가 완료~~\n");
			}
		});
		

		// delete
		f3 = new JFrame();
		f3.setVisible(false);

		p8 = new Panel();
		p8.add(new JLabel("삭제할 책 ISBN 입력"));
		p8.add(deleteISBN = new TextField(20));
		f3.add(p8, BorderLayout.NORTH);


		deleteISBN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				book.deleteBook(deleteISBN.getText());
				deleteISBN.setText("");
				
				output.append(deleteISBN.getText()+ "도서 삭제 완료\n");
			}
		});


	
		setSize(700, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요.":
			output.append("아래의 버튼을 누르세요!\n");
			break;
		
		
		case "Search by Title":

			f1.setVisible(true);
			f1.setSize(300, 80);
			break;

		case "Add Book":

			f2.setVisible(true);
			f2.setSize(380, 100);
			break;

		case "Delete Book":
			
			f3.setVisible(true);
			f3.setSize(350, 80);
			
			break;

		case "Print Book List":
			
			output.append(book.printBookList()+"\n");
			break;
			
		case "Quit":
			
		quit.setVisible(false);
		dispose();
		System.exit(0);
		
		}

	}

}

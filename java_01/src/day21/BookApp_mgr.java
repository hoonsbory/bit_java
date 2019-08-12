package day21;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import day19.BookMgr2_Map;

class MyCanvas extends Canvas {
	Image img2 = Toolkit.getDefaultToolkit().getImage("c://img//bit.jpg");
	Image img3 = Toolkit.getDefaultToolkit().getImage("c://img//book1.jpg");

	public void paint(Graphics g) {
		g.drawImage(img2, 0, 0, 200, 100, this);

		g.drawImage(img3, 200, 200, 400, 700, this);
	}

}

public class BookApp_mgr {
	public static void main(String[] args) {
		new UI_5().createUI();
		
	}
}

class UI_5 extends Book2_Map implements ActionListener { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.
	JFrame f1;
	JButton find, delete, list, exit, add;
	Panel p1, p2, p3;
	TextArea t1;
	TextField msg;
	JTextArea output;
	Font font1 = new Font("serif", Font.BOLD, 20);
	JLabel l1;

	BookMgr2_Map mgr = new BookMgr2_Map();

	Map<Integer, Book2_Map> map = null;

	public UI_5() {
		map = new HashMap<Integer, Book2_Map>();
	}

	void createUI() {

		MyCanvas canvas = new MyCanvas();

		Image img = Toolkit.getDefaultToolkit().getImage("c://img//book2.jpg");

		// MyCanvas canvas = new MyCanvas();
		f1 = new JFrame("도서관리 프로그램");
		f1.setVisible(true);
		p1 = new Panel();
		t1 = new TextArea();
		f1.setIconImage(img);

		f1.add(canvas, BorderLayout.LINE_END);
		canvas.setSize(1250, 1000);
		f1.setSize(1000, 1000);
		// canvas.setLocation(600, 100);
		p1.add(find = new JButton("find"));
		p1.add(delete = new JButton("delete"));
		p1.add(list = new JButton("list"));
		p1.add(exit = new JButton("종료"));
		p1.add(add = new JButton("add"));

		f1.add(p1, BorderLayout.SOUTH);

		p2 = new Panel();
		p3 = new Panel();
		p2.setLayout(new GridLayout(1, 2, 20, 30));

		
		p2.add(msg = new TextField());
		f1.add(p2, BorderLayout.NORTH);
		f1.add(output = new JTextArea(null, 100, 4));
		find.addActionListener(this);
		exit.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		add.addActionListener(this);

		p2.add(l1 = new JLabel("제목/가격을 입력해서 책을 등록하세요"));
		f1.setSize(300, 300);
		f1.setVisible(true);

		f1.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				f1.setVisible(false);
				f1.dispose();
				System.exit(0);
			}
		});

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("add")) {
			
			msg.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					output.setText("");

					String a = msg.getText();

					msg.setText("");

					if (!(a.contains("/"))) {
						output.append("/를 넣어서 입력해주세요 " + "\n");
					} else {
						String[] data = a.trim().split("/");

						Iterator<Integer> it = map.keySet().iterator();

						while (it.hasNext()) {
							Integer integer = (Integer) it.next();
							Book2_Map data1 = map.get(integer);
							if (map.size() != 0 && data1.getTitle().equals(data[0])) {
								output.append("이미 있는 책입니다 다시 입력해주세요.");
								return;
							}
						}
						if (data.length != 2 || data[0].equals("")) {
							output.append("다시입력해주세요 제목/가격" + "\n");

						} else {
							try {
								map.put(map.size() + 1, new Book2_Map(map.size() + 1, data[0], Integer.parseInt(data[1])));

								output.append("등록 완료되었습니다" + "\n");
								System.out.println(map);
								msg.removeActionListener(this);
								msg.setText("");
							} catch (Exception b) {
								output.append("가격은 숫자로 입력해주세요" + "\n");

							} finally {

							}

						}
					}

				}
			});
		}
		if (e.getActionCommand().equals("find")) {
			output.setText("");
			if (map.size() == 0) {

				output.append("책등록해" + "\n");

				return;
			}
			output.append("검색할 책 이름을 입력하세요" + "\n");
			msg.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				//	String a = JOptionPane.showInputDialog("찾고싶은 책이름을 입력하세요");
					String a = msg.getText();
					
					output.append("제목 " + a + " 검색 결과 " + "\n");
					Iterator<Integer> it = map.keySet().iterator();
					while (it.hasNext()) {
						Integer isbn = it.next();
						Book2_Map data = map.get(isbn);
						if (data.getTitle().toUpperCase().contains(a.toUpperCase())) {
							output.append(data.toString());
						}
					}
					msg.setText("");
					output.append("=====================" + "\n");	
					msg.removeActionListener(this);
				}
			});
		}
		if (e.getActionCommand().equals("delete")) {
			output.setText("");
			if (map.size() == 0) {
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			output.append("삭제할 책 이름을 입력하세요" + "\n");
			msg.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
					String a = msg.getText();
					Iterator<Integer> it = map.keySet().iterator();
					int count = 0;
					while (it.hasNext()) {
						Integer isbn = it.next();
						Book2_Map data = map.get(isbn);
						count++;
						if (data.getTitle().equals(a)) {

							// map.remove(isbn);
							it.remove();
							count--;
							output.append(data.toString() + "삭제 완료" + "\n");
							
						}
						data.setIsbn(count);
					}
					msg.setText("");
					output.append("모든 책을 검색했습니다. " + "\n");
					msg.removeActionListener(this);
				}
			});
			
		}
		
	}

	

	
	
}

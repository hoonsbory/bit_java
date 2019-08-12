package day21_ex_Book;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



class MyCanvas extends Canvas {
	Image img2 = Toolkit.getDefaultToolkit().getImage("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_07\\신재훈\\bb.jpg");

	// Image img2 = Toolkit.getDefaultToolkit().getImage("c://img//cat.gif");
	public void paint(Graphics g) {
		g.drawImage(img2, 0, 0, 1000, 250, this);

	}

}

public class BookApp_mgr {
	public static void main(String[] args) {

		new UI_5().createUI();

	}
}

class UI_5 extends Book2_Map implements Serializable ,ActionListener { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.
	JFrame f1, f2, f3, f4;
	JButton find, delete, list, exit, add, save, load;
	Panel p1, p2, p3, p4, p5, p6, p7;
	TextArea t1;
	TextField msg, t2, t3, t4, t5;
	JTextArea output;
	Font font1 = new Font("나눔고딕 ExtraBold", Font.BOLD, 40);
	Font font2 = new Font("나눔고딕 ExtraBold", Font.BOLD, 20);
	Font font3 = new Font("나눔고딕 ExtraBold", Font.BOLD, 20);
	JLabel l1, l2, l3, l4;
	Image image;
	Map<Integer, Book2_Map> map = null;

	public UI_5() {
		map = new HashMap<Integer, Book2_Map>();
 }

	void createUI() {

		MyCanvas canvas = new MyCanvas();

		Image img = Toolkit.getDefaultToolkit()
				.getImage("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_05\\신재훈\\book2.jpg");

		// MyCanvas canvas = new MyCanvas();
		f1 = new JFrame("도서관리 프로그램");
		f2 = new JFrame("도서관리 프로그램");
		f3 = new JFrame("도서관리 프로그램");
		f4 = new JFrame("도서관리 프로그램");
		JLabel j = new JLabel("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_05\\신재훈\\book2.jpg");

		f1.setVisible(true);
		f2.setVisible(false);
		f3.setVisible(false);
		f4.setVisible(false);
		f2.setSize(400, 100);
		f3.setSize(400, 100);
		f4.setSize(400, 100);
		f2.setLocation(500, 295);
		f3.setLocation(500, 295);
		f4.setLocation(500, 295);
		p1 = new Panel();
		t1 = new TextArea();
		f1.setIconImage(img);

		// f1.add(canvas, BorderLayout.PAGE_START);
		// canvas.setSize(100, 100);
		f1.setSize(1000, 850);
		// canvas.setLocation(600, 100);

		// f1.add(p3, BorderLayout.SOUTH);

		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p4.setLayout(new GridLayout(1, 2, 10, 10));
		p4.add(l2 = new JLabel("책 제목/가격을 입력하세요"));
		p4.add(t2 = new TextField(20));

		p5 = new Panel();
		p5.setLayout(new GridLayout(1, 2, 10, 10));
		p5.add(l2 = new JLabel(" 찾으려는 책 제목을 입력하세요"));
		p5.add(t3 = new TextField(20));
		p6 = new Panel();
		p6.setLayout(new GridLayout(1, 2, 10, 10));
		p6.add(l2 = new JLabel(" 찾으려는 책 제목을 입력하세요"));
		p6.add(t4 = new TextField(20));
		p7 = new Panel();

		f1.setMaximizedBounds(new Rectangle(0, 0, 1000, 850));
		f2.add(p4, BorderLayout.NORTH);
		f3.add(p5, BorderLayout.NORTH);
		f4.add(p6, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(1, 1, 0, 0));
		p2.add(p7);
		p7.setBackground(Color.ORANGE);
		p7.add(add = new JButton("등록"));
		p7.add(find = new JButton("검색"));
		p7.add(delete = new JButton("삭제"));
		p7.add(list = new JButton("목록"));
		p7.add(exit = new JButton("종료"));
		p7.add(save = new JButton("save"));
		p7.add(load = new JButton("load"));
		add.setBorderPainted(false);
		find.setBorderPainted(false);
		delete.setBorderPainted(false);
		list.setBorderPainted(false);
		exit.setBorderPainted(false);
		load.setBorderPainted(false);
		save.setBorderPainted(false);
		add.setContentAreaFilled(false);
		find.setContentAreaFilled(false);
		list.setContentAreaFilled(false);
		exit.setContentAreaFilled(false);
		delete.setContentAreaFilled(false);
		save.setContentAreaFilled(false);
		load.setContentAreaFilled(false);
		
		

//		add.setBounds(0, 250, 200, 130);
//		list.setBounds(200, 250, 200, 130);
//		find.setBounds(400, 250, 200, 130);
//		delete.setBounds(600, 250, 200, 130);
//		exit.setBounds(800, 250, 200, 130);
		add.setFont(font1);
		list.setFont(font1);
		find.setFont(font1);
		delete.setFont(font1);
		exit.setFont(font1);
		load.setFont(font1);
		save.setFont(font1);

		f1.add(p1, BorderLayout.CENTER);
		f1.add(p2, BorderLayout.SOUTH);
		canvas.setSize(1000, 250);
		f1.add(p3, BorderLayout.NORTH);
		p3.setLayout(new GridLayout(1, 1, 1, 1));
		p3.add(canvas);
		p1.add(output = new JTextArea(null, 1, 1));
		output.setFont(font2);
		p2.setLayout(new GridLayout(2, 1, 1, 1));
		p2.add(l4 = new JLabel("도서 관리 프로그램  ver1.0  제작자 - 비트캠프 신재훈"));
		l4.setFont(font3);
		// f1.add(output = new JTextArea(null, 50, 4));
		find.addActionListener(this);
		exit.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		add.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);

		// f1.setSize(300, 300);
		f1.setVisible(true);

		f1.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				f1.setVisible(false);
				f1.dispose();
				System.exit(0);
			}
		});

		t4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
				String a = t4.getText().trim();
				Iterator<Integer> it = map.keySet().iterator();
				int count = 0;
				while (it.hasNext()) {
					Integer isbn = it.next();
					Book2_Map data = map.get(isbn);
					count++;
					if (data.getTitle().equals(a)) {

						// map.remove(isbn);
						output.setText("");
						output.append(data.toString() + "삭제 완료" + "\n");
						it.remove();
						count--;

					}

					data.setIsbn(count);
				}
				if (output.getText().contains("모든")) {
					output.setText("");
				}
				output.append("모든 책을 검색했습니다. " + "\n");
				// output.setText("");
				delete.setEnabled(true);

				t4.setText("");
			}
		});

		t3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// String a = JOptionPane.showInputDialog("찾고싶은 책이름을 입력하세요");
				String a = t3.getText().trim();
				output.setText("");
				output.append("제목 [ " + a + " ]검색 결과 " + "\n");
				Iterator<Integer> it = map.keySet().iterator();
				while (it.hasNext()) {
					Integer isbn = it.next();
					Book2_Map data = map.get(isbn);
					if (data.getTitle().toUpperCase().contains(a.toUpperCase())) {
						output.append(data.toString() + "\n");

					} else {

					}
				}

				find.setEnabled(true);
				t3.setText("");
			}
		});

		t2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t2.setText("");
				output.setText("");
				String a = t2.getText().trim();

				if (!(a.contains("/"))) {

					output.append("/를 넣어서 입력해주세요 " + "\n");

				} else {
					String[] data = a.trim().split("/");

					Iterator<Integer> it = map.keySet().iterator();
					if (data.length != 2 || data[0].equals("")) {
						output.append("다시입력해주세요 제목/가격" + "\n");
						return;
					}
					while (it.hasNext()) {
						Integer integer = (Integer) it.next();
						Book2_Map data1 = map.get(integer);
						if (map.size() != 0 && data1.getTitle().equals(data[0])) {
							output.append("이미 있는 책입니다 다시 입력해주세요.");
							return;
						}
					}
					try {
						map.put(map.size() + 1, new Book2_Map(map.size() + 1, data[0], Integer.parseInt(data[1])));
						output.setText("");
						output.append("ISBN = [" + map.size() + "]  제목 = [" + data[0] + "]  가격 = [" + data[1] + "]");
						output.append("등록 완료되었습니다" + "\n");

						t2.setText("");
					} catch (Exception b) {
						output.append("가격은 숫자로 입력해주세요" + "\n");

					}

				}
				t2.setText("");
				add.setEnabled(true);

			}

		});

	};

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요.":
			output.append("아래의 버튼을 누르세요!\n");
			break;

		case "검색":
			if (map.size() == 0) {
				output.setText("");
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}

			f2.dispose();
			f4.dispose();
			f3.setVisible(true);
			delete.setEnabled(true);
			add.setEnabled(true);
			t3.setText("");
			output.setText("");
			if (map.size() == 0) {

				output.append("책등록해" + "\n");

				return;
			}
			output.append("검색할 책 이름을 입력하세요" + "\n");
			break;

		case "등록":

			f3.dispose();
			f4.dispose();
			f2.setVisible(true);

			output.setText("");
			output.append("책 제목과 가격을 입력해주세요");
			break;

		case "삭제":
			if (map.size() == 0) {
				output.setText("");
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}

			f2.dispose();
			f3.dispose();
			f4.setVisible(true);

			add.setEnabled(true);
			find.setEnabled(true);
			t4.setText("");
			output.setText("");
			if (map.size() == 0) {
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			output.append("삭제할 책 이름을 입력하세요" + "\n");

			break;

		case "목록":

			if (map.size() == 0) {
				output.setText("");
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			output.setText("");
			output.append("=========Book List  ==========" + "\n");
			map.forEach((k, v) -> output.append(v.toString() + "\n"));
			output.append("=============================");
			break;

		case "save":
			output.setText("");
			output.append("저장 완료!");
			String file = "book";
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			//Set<Map<Integer, Book2_Map>> set = new HashSet<Map<Integer, Book2_Map>>();
			try {

				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				//set.add(map);
				oos.writeObject(map);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {

			}
			break;

		case "load":
			output.setText("");
			output.append("로드 완료!");
			String filename = "book";
			FileInputStream fis = null;
			ObjectInputStream ois = null;

			try {
				fis = new FileInputStream(filename); // 파일인풋으로 데티어파일 읽어오고
				ois = new ObjectInputStream(fis); // 읽어온 파일은 오브젝트인풋에 넣고
			    map = (Map<Integer, Book2_Map>) ois.readObject();  // 스트링객체는 스트링 타입에
																										// 데이트 객체는
																										// 데이트타입에 넣어준다.
				// Date date = (Date) oos.readObject(); //아까 스트링을 먼저넣었기 때문에 스트링부터 불러와야함. 순서가
				// 중요함.
				// System.out.println(name);
				// name.forEach(i -> System.out.println(i));
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
				e2.printStackTrace();
			} finally {
			
			}
			break;

		case "종료":

			f1.setVisible(false);
			f1.dispose();
			System.exit(0);

		}

	}
}

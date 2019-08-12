package day21_ex_Book;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class MyCanvas2 extends Canvas {
	Image img2 = Toolkit.getDefaultToolkit()
			.getImage("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_07\\신재훈\\bb.jpg");

	// Image img2 = Toolkit.getDefaultToolkit().getImage("c://img//cat.gif");
	public void paint(Graphics g) {
		g.drawImage(img2, 0, 0, 1000, 250, this);

	}

}

class Book_Thread extends Book2_Map implements Serializable, ActionListener { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.

	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	JFrame MainFrame, AddFrame, FindFrame, DeleteFrame, SaveFrame;
	JButton find, delete, list, exit, add, save, SaveYes, SaveNo;
	Panel MainTextPanel, InfoButtonPanel, ImgPanel, AddPanel, FindPanel, DeletePanel, ButtonPanel;
	TextField AddTextField, FindTextField, DeleteTextField;
	JTextArea MainTextArea;
	Font ExtraBold40 = new Font("나눔고딕 ExtraBold", Font.BOLD, 40);
	Font ExtraBold17 = new Font("나눔고딕 ExtraBold", Font.BOLD, 17);
	Font ExtraBold20 = new Font("나눔고딕 ExtraBold", Font.BOLD, 20);
	JLabel l1, l2, l3, l4, l5, l6;
	Boolean AutosaveButton = false;
	Image image;
	Map<Integer, Book2_Map> map = null;
	int count = 0;

	public Book_Thread() {
		map = new HashMap<Integer, Book2_Map>();
	}

	void createUI() {
		T1 th = new T1(); // 이너클래스라서

		Thread Th2 = new Thread(th);

		Th2.start();
		MyCanvas2 canvas = new MyCanvas2();

		Image img = Toolkit.getDefaultToolkit()
				.getImage("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_05\\신재훈\\book2.jpg");

		// MyCanvas canvas = new MyCanvas();
		MainFrame = new JFrame("도서관리 프로그램");
		AddFrame = new JFrame("도서관리 프로그램");
		FindFrame = new JFrame("도서관리 프로그램");
		DeleteFrame = new JFrame("도서관리 프로그램");
		SaveFrame = new JFrame("강제 저장 시스템");
		ImageIcon icon = new ImageIcon("\\\\192.168.0.124\\bitcamp_7class\\1_java\\과제\\08_07\\신재훈\\라이언.gif");

		MainFrame.setVisible(true);
		AddFrame.setVisible(false);
		FindFrame.setVisible(false);
		DeleteFrame.setVisible(false);
		AddFrame.setSize(400, 100);
		FindFrame.setSize(400, 100);
		DeleteFrame.setSize(400, 100);
		AddFrame.setLocation(500, 295);
		FindFrame.setLocation(500, 295);
		DeleteFrame.setLocation(500, 295);
		SaveFrame.setBounds(500, 100, 440, 600);
		MainTextPanel = new Panel();
		MainFrame.setIconImage(img);
		// f1.add(canvas, BorderLayout.PAGE_START);
		// canvas.setSize(100, 100);
		MainFrame.setSize(1000, 850);
		// canvas.setLocation(600, 100);

		// f1.add(p3, BorderLayout.SOUTH);

		InfoButtonPanel = new Panel();
		ImgPanel = new Panel();
		AddPanel = new Panel();
		AddPanel.setLayout(new GridLayout(1, 2, 10, 10));
		AddPanel.add(l2 = new JLabel("책 제목/가격을 입력하세요"));
		AddPanel.add(AddTextField = new TextField(20));

		FindPanel = new Panel();
		FindPanel.setLayout(new GridLayout(1, 2, 10, 10));
		FindPanel.add(l2 = new JLabel(" 찾으려는 책 제목을 입력하세요"));
		FindPanel.add(FindTextField = new TextField(20));
		DeletePanel = new Panel();
		DeletePanel.setLayout(new GridLayout(1, 2, 10, 10));
		DeletePanel.add(l2 = new JLabel(" 삭제할 책 제목을 입력하세요"));
		DeletePanel.add(DeleteTextField = new TextField(20));
		ButtonPanel = new Panel();

		MainFrame.setMaximizedBounds(new Rectangle(0, 0, 1000, 850));
		AddFrame.add(AddPanel, BorderLayout.NORTH);
		FindFrame.add(FindPanel, BorderLayout.NORTH);
		DeleteFrame.add(DeletePanel, BorderLayout.NORTH);
		MainTextPanel.setLayout(new GridLayout(1, 1, 0, 0));
		InfoButtonPanel.add(ButtonPanel);
		ButtonPanel.setBackground(Color.ORANGE);
		ButtonPanel.add(add = new JButton("등록"));
		ButtonPanel.add(find = new JButton("검색"));
		ButtonPanel.add(delete = new JButton("삭제"));
		ButtonPanel.add(list = new JButton("목록"));
		ButtonPanel.add(exit = new JButton("종료"));
		ButtonPanel.add(save = new JButton("저장"));
		SaveFrame.add(SaveYes = new JButton("하..할게요.."));
		SaveYes.setBounds(44, 500, 200, 50);
		SaveFrame.add(SaveNo = new JButton("진짜 안해도 돼요!"));
		SaveNo.setBounds(214, 500, 200, 50);
		SaveFrame.add(l5 = new JLabel("지금 저장을 안하고 종료하시겠다~?"));
		l5.setFont(ExtraBold20);
		SaveYes.setFont(ExtraBold17);
		SaveNo.setFont(ExtraBold17);
		l5.setBounds(50, 20, 400, 20);
		SaveFrame.add(l6 = new JLabel(icon));
		l6.setBounds(0, 100, 200, 200);

		add.setBorderPainted(false);
		find.setBorderPainted(false);
		delete.setBorderPainted(false);
		list.setBorderPainted(false);
		exit.setBorderPainted(false);
		save.setBorderPainted(false);
		SaveNo.setBorderPainted(false);
		SaveYes.setBorderPainted(false);
		add.setContentAreaFilled(false);
		find.setContentAreaFilled(false);
		list.setContentAreaFilled(false);
		exit.setContentAreaFilled(false);
		delete.setContentAreaFilled(false);
		save.setContentAreaFilled(false);
		SaveYes.setContentAreaFilled(false);
		SaveNo.setContentAreaFilled(false);

//		add.setBounds(0, 250, 200, 130);
//		list.setBounds(200, 250, 200, 130);
//		find.setBounds(400, 250, 200, 130);
//		delete.setBounds(600, 250, 200, 130);
//		exit.setBounds(800, 250, 200, 130);
		add.setFont(ExtraBold40);
		list.setFont(ExtraBold40);
		find.setFont(ExtraBold40);
		delete.setFont(ExtraBold40);
		exit.setFont(ExtraBold40);
		save.setFont(ExtraBold40);

		MainFrame.add(MainTextPanel, BorderLayout.CENTER);
		MainFrame.add(InfoButtonPanel, BorderLayout.SOUTH);
		canvas.setSize(1000, 250);
		MainFrame.add(ImgPanel, BorderLayout.NORTH);
		ImgPanel.setLayout(new GridLayout(1, 1, 1, 1));
		ImgPanel.add(canvas);
		MainTextPanel.add(MainTextArea = new JTextArea(null, 1, 1));
		MainTextArea.setFont(ExtraBold20);
		InfoButtonPanel.setLayout(new GridLayout(2, 1, 1, 1));
		InfoButtonPanel.add(l4 = new JLabel("도서 관리 프로그램  ver1.0  제작자 - 비트캠프 신재훈"));
		l4.setFont(ExtraBold20);
		// f1.add(output = new JTextArea(null, 50, 4));
		find.addActionListener(this);
		exit.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		add.addActionListener(this);
		save.addActionListener(this);
		SaveYes.addActionListener(this);
		SaveNo.addActionListener(this);

		// f1.setSize(300, 300);
		MainFrame.setVisible(true);

		UI_Thread(MainFrame);

		MainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (count == 0) {

					int result = JOptionPane.showConfirmDialog(null, "저장을 안하셨습니다 저장하시겠습니까?");
					if (result == JOptionPane.CLOSED_OPTION) {

						MainFrame.setVisible(false);
						MainFrame.dispose();
						System.exit(0);

					}

					else if (result == JOptionPane.NO_OPTION) {
						MainFrame.setVisible(false);
						MainFrame.dispose();
						System.exit(0);
					} else if (result == JOptionPane.CANCEL_OPTION) {
						MainFrame.setVisible(false);
						MainFrame.dispose();
						System.exit(0);
					}

					else {
						addbook();
						MainFrame.setVisible(false);
						MainFrame.dispose();
						System.exit(0);
					}
				} else {
					MainFrame.setVisible(false);
					MainFrame.dispose();
					System.exit(0);
				}
			}

		});

		DeleteTextField.addActionListener(e -> { //람다

			// String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
			String a = DeleteTextField.getText().trim();
			Iterator<Integer> it = map.keySet().iterator();
			int count = 0;
			while (it.hasNext()) {
				Integer isbn = it.next();
				Book2_Map data = map.get(isbn);
				count++;
				if (data.getTitle().equals(a)) {

					// map.remove(isbn);
					MainTextArea.setText("");
					MainTextArea.append(data.toString() + "삭제 완료" + "\n");
					it.remove();
					count--;

				}

				data.setIsbn(count);
			}
			if (MainTextArea.getText().contains("모든")) {
				MainTextArea.setText("");
			}
			MainTextArea.append("모든 책을 검색했습니다. " + "\n");
			// output.setText("");
			delete.setEnabled(true);

			DeleteTextField.setText("");

		});

		FindTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// String a = JOptionPane.showInputDialog("찾고싶은 책이름을 입력하세요");
				String a = FindTextField.getText().trim();
				MainTextArea.setText("");
				MainTextArea.append("제목 [ " + a + " ]검색 결과 " + "\n");
				Iterator<Integer> it = map.keySet().iterator();
				while (it.hasNext()) {
					Integer isbn = it.next();
					Book2_Map data = map.get(isbn);
					if (data.getTitle().toUpperCase().contains(a.toUpperCase())) {
						MainTextArea.append(data.toString() + "\n");

					} else {

					}
				}

				find.setEnabled(true);
				FindTextField.setText("");
			}
		});

		AddTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddTextField.setText("");
				MainTextArea.setText("");
				String a = AddTextField.getText().trim();

				if (!(a.contains("/"))) {

					MainTextArea.append("/를 넣어서 입력해주세요 " + "\n");

				} else {
					String[] data = a.trim().split("/");

					Iterator<Integer> it = map.keySet().iterator();
					if (data.length != 2 || data[0].equals("")) {
						MainTextArea.append("다시입력해주세요 제목/가격" + "\n");
						return;
					}
					while (it.hasNext()) {
						Integer integer = (Integer) it.next();
						Book2_Map data1 = map.get(integer);
						if (map.size() != 0 && data1.getTitle().equals(data[0])) {
							MainTextArea.append("이미 있는 책입니다 다시 입력해주세요.");
							return;
						}
					}
					try {
						map.put(map.size(), new Book2_Map(map.size() + 1, data[0], Integer.parseInt(data[1])));
						MainTextArea.setText("");
						MainTextArea
								.append("ISBN = [" + map.size() + "]  제목 = [" + data[0] + "]  가격 = [" + data[1] + "]");
						MainTextArea.append("등록 완료되었습니다" + "\n");

						AddTextField.setText("");
					} catch (Exception b) {
						MainTextArea.append("가격은 숫자로 입력해주세요" + "\n");

					}

				}
				AddTextField.setText("");
				add.setEnabled(true);

			}

		});

	};

	private void UI_Thread(JFrame f1) {

		MainTextArea.append("=====도서 관리 프로그램=====" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("등록을 눌러 책 정보를 등록하세요!" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("검색을 눌러 책 정보를 검색하세요!" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("목록을 눌러 책 정보를 출력하세요!" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("삭제를 눌러 책 정보를 삭제하세요!" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("저장을 눌러 책 정보를 저장하세요!" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("종료를 원하시면 종료를 눌러주세요" + "\n");
		MainTextArea.append("\n");
		MainTextArea.append("=========================" + "\n");
		int a = JOptionPane.showConfirmDialog(null, "자동저장 기능을 사용하시겠습니까? (10초마다 자동저장)");

		if (a == JOptionPane.OK_OPTION) {

			AutosaveButton = true;
		}

		MainTextArea.append("책 정보 로드 완료!");
		String filename = "book1";
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(filename); // 파일인풋으로 데티어파일 읽어오고
//			if(fis ==null) {
//				return;
//			}
			ois = new ObjectInputStream(fis); // 읽어온 파일은 오브젝트인풋에 넣고
			map = (Map<Integer, Book2_Map>) ois.readObject(); // 스트링객체는 스트링 타입에
																// 데이트 객체는
																// 데이트타입에 넣어준다.
			// Date date = (Date) oos.readObject(); //아까 스트링을 먼저넣었기 때문에 스트링부터 불러와야함. 순서가
			// 중요함.
			// System.out.println(name);
			// name.forEach(i -> System.out.println(i));
		} catch (Exception e2) {
			try {
				fos = new FileOutputStream(filename);
				oos = new ObjectOutputStream(fos);
				fos.write(null);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
			}
		} finally {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요.":
			MainTextArea.append("아래의 버튼을 누르세요!\n");
			break;

		case "검색":
			if (map.size() == 0) {
				MainTextArea.setText("");
				MainTextArea.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}

			AddFrame.dispose();
			DeleteFrame.dispose();
			FindFrame.setVisible(true);
			delete.setEnabled(true);
			add.setEnabled(true);
			FindTextField.setText("");
			MainTextArea.setText("");
			if (map.size() == 0) {

				MainTextArea.append("책등록해" + "\n");

				return;
			}
			MainTextArea.append("검색할 책 이름을 입력하세요" + "\n");
			break;

		case "등록":

			FindFrame.dispose();
			DeleteFrame.dispose();
			AddFrame.setVisible(true);
			System.out.println(map.size());
			MainTextArea.setText("");
			MainTextArea.append("책 제목과 가격을 입력해주세요");
			break;

		case "삭제":
			if (map.size() == 0) {
				MainTextArea.setText("");
				MainTextArea.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}

			AddFrame.dispose();
			FindFrame.dispose();
			DeleteFrame.setVisible(true);

			add.setEnabled(true);
			find.setEnabled(true);
			DeleteTextField.setText("");
			MainTextArea.setText("");
			if (map.size() == 0) {
				MainTextArea.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			MainTextArea.append("삭제할 책 이름을 입력하세요" + "\n");

			break;

		case "목록":

			if (map.size() == 0) {
				MainTextArea.setText("");
				MainTextArea.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			MainTextArea.setText("");
			MainTextArea.append("=========Book List  ==========" + "\n");
			map.forEach((k, v) -> MainTextArea.append(v.toString() + "\n"));

			MainTextArea.append("=============================");
			break;

		case "저장":
			addbook();
			break;
//		case "load":
//			output.setText("");
//			output.append("로드 완료!");
//			String filename = "book1";
//			FileInputStream fis = null;
//			ObjectInputStream ois = null;
//
//			try {
//				fis = new FileInputStream(filename); // 파일인풋으로 데티어파일 읽어오고
//				ois = new ObjectInputStream(fis); // 읽어온 파일은 오브젝트인풋에 넣고
//			    map = (Map<Integer, Book2_Map>) ois.readObject();  // 스트링객체는 스트링 타입에
//																										// 데이트 객체는
//																										// 데이트타입에 넣어준다.
//				// Date date = (Date) oos.readObject(); //아까 스트링을 먼저넣었기 때문에 스트링부터 불러와야함. 순서가
//				// 중요함.
//				// System.out.println(name);
//				// name.forEach(i -> System.out.println(i));
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//				e2.printStackTrace();
//			} finally {
//			
//			}
//			break;
		case "하..할게요..":
			addbook();
			SaveFrame.setVisible(false);
			SaveFrame.dispose();
			break;
		case "진짜 안해도 돼요!":
			MainFrame.setVisible(false);
			MainFrame.dispose();
			System.exit(0);

			break;
		case "종료":
			if (count == 0) {

				int result = JOptionPane.showConfirmDialog(null, "저장을 안하셨습니다 저장하시겠습니까?");
				if (result == JOptionPane.CLOSED_OPTION) {
					MainTextArea.setText("");
					MainTextArea.append("저장하세요~");
				} else if (result == JOptionPane.NO_OPTION) {
					SaveFrame.setVisible(true);

				} else if (result == JOptionPane.CANCEL_OPTION) {
					MainTextArea.setText("");
					MainTextArea.append("저장하세요~");
				}

				else {
					addbook();
				}
			} else {
				MainFrame.setVisible(false);
				MainFrame.dispose();
				System.exit(0);
			}
		}

	}

	void addbook() {

		MainTextArea.setText("");
		MainTextArea.append("저장 완료!");
		String file = "book1";

		// Set<Map<Integer, Book2_Map>> set = new HashSet<Map<Integer, Book2_Map>>();
		try {

			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			// set.add(map);
			oos.writeObject((Object) map);
			oos.flush();
			count++;
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();

				if (oos != null)
					oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public class T1 implements Runnable {

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(5000);
					if (AutosaveButton == false) {
						break;
					}
					addbook();
					System.out.println("저장완료");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}

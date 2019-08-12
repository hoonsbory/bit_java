package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import day19.Book;
import day19.BookMgr2_Map;
import day21_ex_Book.Book2_Map;

public class awt5 {
	public static void main(String[] args) {
		new UI_5().createUI();

	}
}

class UI_5 extends Book2_Map implements ActionListener { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.
	JFrame f1;
	JButton find, delete, list, exit;
	Panel p1, p2;
	JTextArea t1;
	Label l1;
	TextField msg;
	TextArea output;
	BookMgr2_Map mgr = new BookMgr2_Map();

	Map<Integer, Book2_Map> map = null;

	public UI_5() {
		map = new HashMap<Integer, Book2_Map>();
	}

	void createUI() { // 생성자함수가 아닌 그냥 메소드이므로 따로 부모의 타이틀을 지정해준다
		f1 = new JFrame("도서관리 프로그램"); // 요로케
		// super("awt UI Test ~~"); // 생성자함수 슈퍼를 통해 프레임을 상속받은 프레임클래스에 적용됨.
		p1 = new Panel();
		t1 = new JTextArea();
		p1.add(find = new JButton("find")); // 패널에 버튼 세개 넣고
		p1.add(delete = new JButton("delete"));
		p1.add(list = new JButton("list"));
		p1.add(exit = new JButton("종료"));
		f1.add(p1, BorderLayout.SOUTH); // 프레임에 그 패널을 넣음 보더레이아웃.으로 방향 패널의 방향 지정가능
		// add(t1, BorderLayout.LINE_START);
		// t1.setBackground(Color.DARK_GRAY);
		f1.setSize(1000, 1000);
		p2 = new Panel();
		p2.setLayout(new GridLayout(1, 2, 20, 30));
		p2.add(new JLabel("제목/가격을 입력해서 책을 등록하세요"));
		p2.add(msg = new TextField());
		f1.add(p2, BorderLayout.NORTH);
		f1.add(output = new TextArea());

		msg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// output.append(msg.getText()+"\n");
				// msg.setText("");
				output.setText("");
				String a = msg.getText();
				msg.setText("");
//				mgr.addBook(a);
//				msg.setText("");
//				output.append("등록 완료되었습니다");
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
						} catch (Exception b) {
							output.append("가격은 숫자로 입력해주세요" + "\n");

						} finally {

						}

					}
				}

			}
		});

		find.addActionListener(this);
		exit.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		f1.setSize(300, 300); // 사이즈 지정하고 눈에 보이게 비지블값을 트루로 줌
		f1.setVisible(true);

		// red.addActionListener(windowOpened); // 액션이벤트를 감시하는 감시자
		f1.addWindowListener(new WindowAdapter() { // 익명클래스로 바로 오버라이딩해서 사용

			public void windowClosing(WindowEvent e) {
				f1.setVisible(false); // 안보이게 만들어서 일단 바로 꺼진 것처러 ㅁ보이게 함
				f1.dispose(); // 자원파괴 메소드
				System.exit(0);
			}// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 새로추가된 기능 이거 하나로 엑스표시 활성화가능

		});

		// 윈도우 이벤트를 감시하는 감시자, 윈도우 리스너 오버라이딩 통해 윈도우 클로즈 메소드 활성화
		// 어떤 반응을 하기 위해선 그 반응이 들어있는 메소드 주소를 연결해야한다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 액션리스너의 추상메소드를 오버라이딩해서 버튼을 누르면 그 버튼이 파라미터로 적용. 겟액션 커맨드의 이름이 저장돼서 이퀄즈로 조건.

		// System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("find")) { // 스위치로도 가능.
			output.setText("");
			if (map.size() == 0) {

				output.append("책등록해" + "\n");

				return;
			}
			String a = JOptionPane.showInputDialog("찾고싶은 책이름을 입력하세요");
			if (a == null) {
				return;
			}
			output.append("제목 " + a + " 검색 결과 " + "\n");
			Iterator<Integer> it = map.keySet().iterator();
			while (it.hasNext()) {
				Integer isbn = it.next();
				Book2_Map data = map.get(isbn);
				if (data.getTitle().toUpperCase().contains(a.toUpperCase())) {
					// output.append(data);
				}
			}
			output.append("=====================" + "\n");
			// mgr.searchTitleBook();
		} else if (e.getActionCommand().equals("delete")) {
			output.setText("");
			if (map.size() == 0) {
				output.append("책이 없습니다. 등록해주세요" + "\n");
				return;
			}
			String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
			if (a == null) {
				return;
			}
			Iterator<Integer> it = map.keySet().iterator();
			int count = 0;
			while (it.hasNext()) {
				Integer isbn = it.next();
				Book2_Map data = map.get(isbn);
				count++;
				if (data.getTitle().equals(a)) {
					output.append(data + " 삭제됩니다." + "\n");
					// map.remove(isbn);
					it.remove();
					count--;
					output.append(data.toString() + "삭제 완료");
				}
				data.setIsbn(count);
			}
			output.append("찾으시는 책이 없습니다 다시 입력하세요" + "\n");

		} else if (e.getActionCommand().equals("list")) {
			output.setText("");
			if (map.size() == 0) {
				output.append("책이 없습니다. 등록해주세요");
				return;
			}
			output.append("=========Book List==========" + "\n");
			map.forEach((k, v) -> output.append(v.toString() + "\n"));
			output.append("=========================");
		}

		else if (e.getActionCommand().equals("종료")) {
			f1.setVisible(false);
			f1.dispose();
			System.exit(0);
			p1.setBackground(Color.gray);
		}

	}

//	class WindowEvent extends WindowAdapter {
//
//		@Override
//		public void windowClosing(WindowEvent e) {
//		//	f1.setVisible(false);  //안보이게 만들어서 일단 바로 꺼진 것처러 ㅁ보이게 함
//		//	f1.dispose(); //자원파괴 메소드
//			System.exit(0);
//		}
//
//	}
}

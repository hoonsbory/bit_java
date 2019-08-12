package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class awt4 {
	public static void main(String[] args) {
		new UI_4();
	}
}

class UI_4 extends JFrame implements ActionListener, MouseMotionListener { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.
	// Frame f1;
	JButton red, blue, exit, clear;
	Panel p1;
	JTextArea t1;
	Label l1;

	public UI_4() {
		super("awt UI Test ~~"); // 생성자함수 슈퍼를 통해 프레임을 상속받은 프레임클래스에 적용됨.
		p1 = new Panel();
		t1 = new JTextArea();
		p1.add(red = new JButton("red")); // 패널에 버튼 세개 넣고
		p1.add(blue = new JButton("blue"));
		p1.add(exit = new JButton("종료"));
		add(p1, BorderLayout.LINE_END); // 프레임에 그 패널을 넣음 보더레이아웃.으로 방향 패널의 방향 지정가능
		// add(t1, BorderLayout.LINE_START);
		// t1.setBackground(Color.DARK_GRAY);
		p1.add(l1 = new Label("따라간당~~~~~~"));
		l1.setBounds(100, 50, 100, 100);
		l1.setBackground(Color.GREEN);
		
		
		
		 
		red.addActionListener(this);
		exit.addActionListener(this);
		blue.addActionListener(this);
		p1.addMouseMotionListener(this);
		setSize(300, 300); // 사이즈 지정하고 눈에 보이게 비지블값을 트루로 줌
		setVisible(true);

		// red.addActionListener(windowOpened); // 액션이벤트를 감시하는 감시자
		addWindowListener(new WindowAdapter() { // 익명클래스로 바로 오버라이딩해서 사용
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게 만들어서 일단 바로 꺼진 것처러 ㅁ보이게 함
				dispose(); // 자원파괴 메소드
				System.exit(0);
			}//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 새로추가된 기능 이거 하나로 엑스표시 활성화가능
		});

		// 윈도우 이벤트를 감시하는 감시자, 윈도우 리스너 오버라이딩 통해 윈도우 클로즈 메소드 활성화
		// 어떤 반응을 하기 위해선 그 반응이 들어있는 메소드 주소를 연결해야한다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 액션리스너의 추상메소드를 오버라이딩해서 버튼을 누르면 그 버튼이 파라미터로 적용. 겟액션 커맨드의 이름이 저장돼서 이퀄즈로 조건.
		System.out.println("치킨먹자");
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("red")) { // 스위치로도 가능.

			l1.setBackground(Color.red);
		} else if (e.getActionCommand().equals("blue")) {

			l1.setBackground(Color.blue);
		} else if (e.getActionCommand().equals("종료")) {
			setVisible(false);
			dispose();
			System.exit(0);
			p1.setBackground(Color.gray);
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
			
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		l1.setLocation(p);

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

package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class awt {
	public static void main(String[] args) {
		new UI_5();
	}
}

class UI_1 { // 클래스 자체가 프레임을 상속받아서 사용할 수 있음.
	Frame f1;
	Button red, blue, exit;
	Panel p1;
	TextArea t1;
	public UI_1() {
		p1 = new Panel();
		t1 = new TextArea();
		f1 = new Frame("BookApp");
		p1.add(red = new Button("red")); // 패널에 버튼 세개 넣고
		p1.add(blue = new Button("blue"));
		p1.add(exit = new Button("exit"));
		f1.add(p1, BorderLayout.EAST); // 프레임에 그 패널을 넣음 보더레이아웃.으로 방향 패널의 방향 지정가능
		
		f1.add(t1, BorderLayout.WEST);
		t1.setBackground(Color.DARK_GRAY);
		f1.setSize(300, 300); // 사이즈 지정하고 눈에 보이게 비지블값을 트루로 줌
		f1.setVisible(true);
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t1.setBackground(Color.red);
			}
		});
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.blue);
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setBackground(Color.black);
			}
		});
		// red.addActionListener(windowOpened); // 액션이벤트를 감시하는 감시자
		f1.addWindowListener(new WindowAdapter() { // 익명클래스로 바로 오버라이딩해서 사용
			public void windowClosing(WindowEvent e) {
				f1.setVisible(false); // 안보이게 만들어서 일단 바로 꺼진 것처러 ㅁ보이게 함
				f1.dispose(); // 자원파괴 메소드
				System.exit(0);
			}
		});

		// 윈도우 이벤트를 감시하는 감시자, 윈도우 리스너 오버라이딩 통해 윈도우 클로즈 메소드 활성화
		// 어떤 반응을 하기 위해선 그 반응이 들어있는 메소드 주소를 연결해야한다.
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

package day21;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Stream;

public class awt6 {
	public static void main(String[] args) {
		new DrawImg();

	}
}

class DrawImg extends Frame {
	Image im;
	TextArea t;
	DrawImg() {
	
	
		im = Toolkit.getDefaultToolkit().createImage("c://img//lol.gif");
		setSize(2000, 2000);
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		String[] fontlist = Toolkit.getDefaultToolkit().getFontList(); //api중에 선이그어진 것은 디프리케이티드된 api라는 뜻
		Stream.of(fontlist).forEach(i -> System.out.println(i));
		
		addWindowListener(new WindowAdapter() { // 익명클래스로 바로 오버라이딩해서 사용
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		g.drawImage(im, 0, 0, 1700, 860, this); // this는 이미지 옵저버 느낌.
		
	}

}
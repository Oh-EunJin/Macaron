package report;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame implements ActionListener {

	JButton start;
	JButton info;
	ImageIcon startImg = new ImageIcon("img/start.png");
	ImageIcon infoImg = new ImageIcon("img/help.png");
	JPanel pan;
	
	class BackPan extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new javax.swing.ImageIcon("img/background.png").getImage(), 0, 0, this);
		}
	}
	
	public main() {
		pan=new BackPan();
		pan.setLayout(null);
		
		start = new JButton(startImg);
		start.setBounds(310, 540, 90, 40);
		info = new JButton(infoImg);
		info.setBounds(310, 480, 90, 40);
		
		pan.add(start);
		pan.add(info);
		add(pan);
		
		start.addActionListener(this);
		info.addActionListener(this);
		
		setTitle("Macaron, How much?");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 70, 700, 700);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object bnt = e.getSource();
		if(bnt == start) {
			setVisible(false);
			new GameFrame();
		}
		if(bnt == info) {
			setVisible(true);
			new GameInfo();
		}
	}

	public static void main(String[] args) {
		new main();
	}

}

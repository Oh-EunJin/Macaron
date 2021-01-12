package report;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInfo extends JFrame implements ActionListener {
	
	class BackPan extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new javax.swing.ImageIcon("img/rule.png").getImage(), 0, 0, 720, 500, this);
		}
	}
	JButton exit = new JButton("EXIT");
	JPanel pan = new JPanel();
	
	public GameInfo() {
		pan = new BackPan();
		pan.setLayout(null);
		pan.setBackground(Color.WHITE);
		
		exit.setBounds(20, 20, 80, 30);
		pan.add(exit);
		add(pan, "Center");
		exit.addActionListener(this);
		setTitle("Macaron, How much?");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(480, 150, 720, 500 );
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object bnt = e.getSource();
		if(bnt == exit) {
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new GameInfo();
	}

}

package report;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import report.GamePaper.user_jumsu1;
import report.Ranking.rankPan;

public class Ranking_name extends JFrame{
	JButton sure = new JButton("확 인");
	JPanel pan;
	JTextField user_name;
	JLabel input = new JLabel("닉네임을 입력해주세요");
	
	class rankPan extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new javax.swing.ImageIcon("img/rank.png").getImage(), 0, 0, this);
		}
	}
	public Ranking_name() {
		pan = new rankPan();
		pan.setLayout(null);
		add(pan);
		
		input.setBounds(350,200,200,80);
		pan.add(input);
		
		user_name = new JTextField(15);
		
		user_name.setBounds(350, 260, 150, 20);
		pan.add(user_name);
		
		sure.setBounds(510, 230, 80, 50);
		pan.add(sure);
		
		sure.addActionListener(butHandler);
		
		//sure.addActionListener(butHandler);
		
		setTitle("Macaron, How much?");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 70, 700, 700);
		setVisible(true);
	}
	public void insertSQL() {	//메소드 생성
		Connection con = MyDB.getCon();//연결객체 생성
		String sql = "insert into macaron.macaron_user(user_id, user_jumsu) values(?, ?)";	//sql 작성	//들어갈것 순서대로 작성해준다
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);	//문장객체 생성
			pstmt.setString(1, user_name.getText());	//자료형에 맞춰 String으로 작성
			pstmt.setInt(2, user_jumsu1.user_jumsu);
			
			pstmt.executeUpdate();	//데이터 업데이트시킬 떄
			if(con!=null)
				con.close();//DB의 과부하 발생을 막음
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	ActionListener butHandler = new ActionListener() {	//상속받고 싶은 거, Anonymous타입
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object bnt = e.getSource();
			if(bnt == sure)
			{
				insertSQL();
				setVisible(false);
				new Ranking();
			}
		}
	};
	
	public static void main(String[] args) {
		new Ranking_name();
	}
}

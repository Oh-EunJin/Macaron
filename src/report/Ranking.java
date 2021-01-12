package report;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import report.GameInfo.BackPan;

public class Ranking extends JFrame {
	//String searchWord="";
	int[] user_jumsu;//저장장소
	String[] user_id;
	
	DefaultTableModel model;
	String[] columnArr = {"닉네임", "점수"};
	
	JPanel pan;
	JLabel m_rank = new JLabel("순위"); 
	JLabel m_name = new JLabel("닉네임");
	JLabel m_jumsu = new JLabel("점수");
	
	JLabel m_number1 = new JLabel("1");
	JLabel m_number2 = new JLabel("2");
	JLabel m_number3 = new JLabel("3");
	JLabel m_number4 = new JLabel("4");
	JLabel m_number5 = new JLabel("5");
	JLabel m_number6 = new JLabel("6");
	JLabel m_number7 = new JLabel("7");
	JLabel m_number8 = new JLabel("8");
	JLabel m_number9 = new JLabel("9");
	JLabel m_number10 = new JLabel("10");
	JTable table;
	
	class rankPan extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new javax.swing.ImageIcon("img/rank.png").getImage(), 0, 0, this);
		}
	}
	
	public Ranking() {
		
		pan = new rankPan();
		pan.setLayout(null);
		add(pan);

		m_rank.setBounds(350, 150, 50, 30);
		pan.add(m_rank);
		
		m_name.setBounds(420, 150, 50, 30);
		pan.add(m_name);
		
		m_jumsu.setBounds(530, 150, 50, 30);
		pan.add(m_jumsu);
		
		m_number1.setBounds(360, 180, 30,30);
		pan.add(m_number1);
		m_number2.setBounds(360, 210, 30,30);
		pan.add(m_number2);
		m_number3.setBounds(360, 240, 30,30);
		pan.add(m_number3);
		m_number4.setBounds(360, 270, 30,30);
		pan.add(m_number4);
		m_number5.setBounds(360, 300, 30,30);
		pan.add(m_number5);
		m_number6.setBounds(360, 330, 30,30);
		pan.add(m_number6);
		m_number7.setBounds(360, 360, 30,30);
		pan.add(m_number7);
		m_number8.setBounds(360, 390, 30,30);
		pan.add(m_number8);
		m_number9.setBounds(360, 420, 30,30);
		pan.add(m_number9);
		m_number10.setBounds(360, 450, 30,30);
		pan.add(m_number10);
		
		model = new DefaultTableModel(columnArr, 0) {	//50 : 처음에 보여질 행의 개수
			@Override
			public boolean isCellEditable(int arg0, int arg1) {	//객체의 수정을 위해 오버라이딩
				return false;	//실행했을때 테이블의 셀을 수정하지 못하게한다
			}
		};
		table = new JTable(model);	//model을 가지고 table객체 생성
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setRowHeight(30);
		
		
		table.setBounds(400,180, 200, 200);
		pan.add(table);

		execSQL();//객체를 추가해준다
		setTable();
		
		setTitle("Macaron, How much?");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 70, 700, 700);
		setVisible(true);
		
	}
	
	public void execSQL() {
		Connection con = MyDB.getCon();
		int count=0;
		String sql = "SELECT count(*) " + 
				" FROM macaron.macaron_user u;";//띄어쓰기 조심
				//만족하는 레코드의 개수
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);//예외처리를 해야 쓸 수 있다//문장객체
			//-> %기호를 붙여 검색한 단어가 들어가기만 하면 단어가 들어간 모든게 검색되게 함
			ResultSet rs = pstmt.executeQuery();
			rs.next();	//실행하면 3을 출력한다
			count = rs.getInt(1);	//레코드(행)의 개수를 구할 수 있다
			user_id = new String[count];
			user_jumsu = new int[count];
			
			sql = "SELECT user_num, user_id, user_jumsu" + 
					" FROM macaron.macaron_user u ORDER BY user_jumsu DESC;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i=0;
			while (rs.next()) {	//rs의 다음들
				user_id[i] = rs.getString("user_id");
				user_jumsu[i] = rs.getInt("user_jumsu");
				i++;
			}
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setTable() {	//테이블 설정
		//화면 테이블에 레코드 개수 설정
		model.setRowCount(user_id.length);	//배열의 길이와똑같다
		for (int i = 0; i < user_id.length; i++) { //반복해서 셀에 넣기
			table.setValueAt(user_id[i], i, 0);
			table.setValueAt(user_jumsu[i], i, 1);
		}
	}

}

package project;

import javax.swing.JFrame;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Signin {
	private JTextField t2;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;

	public Signin() {

		JFrame p1 = new JFrame();

		// Class. forName("com.mysql.jdbc.Driver");
		// System.out.println("1.드라이버 설정 ok...");

		// 2.DB연결
		// url. user. password

		// String url = "jdbc:mysql://localhost:3306/phc";
		// String user = "root";
		// String password = "root";

		// Connection con = DriverManager.getConnection(url, user, password);
		// System.out.println("2. DB연결 성공 okayy... ");
		// 3.SQL문 결정

		// String sql = "insert into member2 values =(?,?,?,?,?,?,?)";
		// PreparedStatement ps = con.prepareStatement(sql);

		// ps.setString(1, id);
		// ps.setString(2, name);
		// ps.setInt(3, height);
		// ps.setInt(4, age);
		// ps.setInt(5, weight);
		// ps.setChar(6, gender);
		// ps.setInt(8, gdate);

		// '?' 쓰지 않는다. (?,?,?,?) 이렇게 쓴다.

		// System.out.println("3. SQL 문 객체화 okay");

		// 4.SQL문 실행 요청

		// ResultSet rs = ps.executeQuery();
		// System.out.println("4. SQL문 실행 요청 okay");
		// MemberDTO dto = new MemberDTO();
		// if (rs.next()) {
		// String id = rs.getString(1);
		// String pw = rs.getString(2);
		// String name = rs.getString(3);
		// String tel = rs.getString(4);
		// System.out.println("검색결과입니다.");
		// System.out.println(id);
		// System.out.println(pw);
		// System.out.println(name);
		/// System.out.println(tel);
		// dto.setId(id);
		// dto.setPw(pw);
		// dto.setName(name);
		// dto.setTel(tel);

		// }
		// return dto;// 묶어서 보냄

		////////////////////////////////////////////////////////////////////////////

		p1.setSize(489, 800);
		p1.getContentPane().setLayout(null);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 30));
		t2.setBounds(128, 79, 342, 55);
		p1.getContentPane().add(t2);
		t2.setColumns(30);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setSize(489, 800);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 137, 55);
		p1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 82, 116, 50);
		p1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("키");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(0, 168, 126, 40);
		p1.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(0, 237, 97, 43);
		p1.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("성별");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(0, 307, 97, 40);
		p1.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("몸무게");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(0, 383, 97, 53);
		p1.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("운동 목표");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(0, 470, 172, 61);
		p1.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("목표 날짜");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(0, 554, 179, 54);
		p1.getContentPane().add(lblNewLabel_8);

		JButton b1 = new JButton("회원가입");
		b1.setFont(new Font("굴림", Font.PLAIN, 35));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List me = new List();
				p1.setVisible(false);
			}
		});
		b1.setBounds(83, 662, 285, 49);
		p1.getContentPane().add(b1);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 30));
		t1.setColumns(30);
		t1.setBounds(128, 6, 342, 55);
		p1.getContentPane().add(t1);

		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 30));
		t3.setColumns(30);
		t3.setBounds(128, 160, 342, 55);
		p1.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 30));
		t4.setColumns(30);
		t4.setBounds(128, 230, 342, 55);
		p1.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("굴림", Font.PLAIN, 30));
		t5.setColumns(30);
		t5.setBounds(128, 299, 342, 55);
		p1.getContentPane().add(t5);

		t6 = new JTextField();
		t6.setFont(new Font("굴림", Font.PLAIN, 30));
		t6.setColumns(30);
		t6.setBounds(128, 383, 342, 55);
		p1.getContentPane().add(t6);

		t7 = new JTextField();
		t7.setFont(new Font("굴림", Font.PLAIN, 30));
		t7.setColumns(30);
		t7.setBounds(193, 472, 277, 55);
		p1.getContentPane().add(t7);

		t8 = new JTextField();
		t8.setFont(new Font("굴림", Font.PLAIN, 30));
		t8.setColumns(30);
		t8.setBounds(191, 553, 277, 55);
		p1.getContentPane().add(t8);

		p1.setVisible(true);
	}
}
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
import javax.swing.JPasswordField;

public class Signin2 {
	private JTextField t2;
	private JTextField t1;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JPasswordField t3;

	public static void main(String[] args) {
		new Signin2();
	}

	public Signin2() {

		JFrame p1 = new JFrame("test2");

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
		lblNewLabel_2.setBounds(0, 234, 126, 40);
		p1.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(0, 307, 97, 43);
		p1.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("성별");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(0, 387, 97, 40);
		p1.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("몸무게");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(6, 449, 97, 53);
		p1.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("운동 목표");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(6, 523, 172, 61);
		p1.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("목표 날짜");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(2, 596, 179, 54);
		p1.getContentPane().add(lblNewLabel_8);
		
		JButton b1 = new JButton("회원가입");
		b1.setFont(new Font("굴림", Font.PLAIN, 35));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id = t1.getText();
				String pwd = t2.getText();
				String name = t3.getText();
				int height = Integer.parseInt(t4.getText());
				int age = Integer.parseInt (t5.getText());
				char gender = t6.getText().charAt(0);
				int weight = Integer.parseInt (t7.getText());
				int gcal =Integer.parseInt( t8.getText());
				int gdate = Integer.parseInt(t9.getText());
			
			
				
				MemberDTO dto = new MemberDTO();
				dto.setId(id);
				dto.setName(name);
				dto.setPassword(pwd);
				dto.setHeight(height); // 2가지 케이스 string 을 쳐서 하나를타입하던지, ()안에 넣어서 처리한
				dto.setGender(gender);
				dto.setAge(age);
				dto.setWeight(weight);
				dto.setGcal(gcal);
				dto.setGdate(gdate);
		
				//db process
				MemberDAO dao = new MemberDAO();
				
				try {
					dao.insert(dto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 30));
		t4.setColumns(30);
		t4.setBounds(128, 227, 342, 55);
		p1.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("굴림", Font.PLAIN, 30));
		t5.setColumns(30);
		t5.setBounds(128, 301, 342, 55);
		p1.getContentPane().add(t5);

		t6 = new JTextField();
		t6.setFont(new Font("굴림", Font.PLAIN, 30));
		t6.setColumns(30);
		t6.setBounds(128, 380, 342, 55);
		p1.getContentPane().add(t6);

		t7 = new JTextField();
		t7.setFont(new Font("굴림", Font.PLAIN, 30));
		t7.setColumns(30);
		t7.setBounds(128, 448, 342, 55);
		p1.getContentPane().add(t7);

		t8 = new JTextField();
		t8.setFont(new Font("굴림", Font.PLAIN, 30));
		t8.setColumns(30);
		t8.setBounds(193, 526, 277, 55);
		p1.getContentPane().add(t8);

		t9 = new JTextField();
		t9.setFont(new Font("굴림", Font.PLAIN, 30));
		t9.setColumns(30);
		t9.setBounds(193, 596, 277, 55);
		p1.getContentPane().add(t9);
		
		t3 = new JPasswordField();
		t3.setBounds(128, 158, 342, 49);
		p1.getContentPane().add(t3);
		
		JLabel lblQl = new JLabel("비밀번호");
		lblQl.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblQl.setBounds(0, 157, 116, 50);
		p1.getContentPane().add(lblQl);

		p1.setVisible(true);
	}
}
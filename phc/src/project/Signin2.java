package project;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

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

	public Signin2() {

		JFrame p1 = new JFrame("test2");

		p1.setSize(489, 800);
		p1.getContentPane().setLayout(null);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 30));
		t2.setBounds(193, 79, 277, 40);
		p1.getContentPane().add(t2);
		t2.setColumns(30);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setSize(489, 800);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 14, 137, 40);
		p1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(12, 82, 137, 40);
		p1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("키");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(12, 228, 137, 40);
		p1.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(12, 301, 137, 40);
		p1.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("성별");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(12, 380, 137, 40);
		p1.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("몸무게");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(12, 448, 137, 40);
		p1.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("목표감량(kg)");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(12, 527, 137, 40);
		p1.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("목표날짜(일)");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(12, 596, 137, 40);
		p1.getContentPane().add(lblNewLabel_8);

		JButton b1 = new JButton("회원가입");
		b1.setFont(new Font("굴림", Font.PLAIN, 35));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sign = t1.getText();
				MemberDAO dao = new MemberDAO();
				try {
					boolean result = dao.selectId(sign);
					if (result == false) {
						JOptionPane.showMessageDialog(p1, "가입을 축하드립니다.");
						
						String id = t1.getText();
						String pwd = t3.getText();
						String name = t2.getText();
						int height = Integer.parseInt(t4.getText());
						int age = Integer.parseInt(t5.getText());
						char gender = t6.getText().charAt(0);
						int weight = Integer.parseInt(t7.getText());
						int gcal = Integer.parseInt(t8.getText());
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
						
						dao.insert(dto);
						p1.setVisible(false);
						new List();
						Login.saveId = t1.getText();
						
					} else {
						JOptionPane.showMessageDialog(p1, "아이디가 사용중입니다");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		b1.setBounds(0, 712, 473, 49);
		p1.getContentPane().add(b1);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 30));
		t1.setColumns(30);
		t1.setBounds(193, 14, 277, 40);
		p1.getContentPane().add(t1);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 30));
		t4.setColumns(30);
		t4.setBounds(193, 227, 277, 40);
		p1.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("굴림", Font.PLAIN, 30));
		t5.setColumns(30);
		t5.setBounds(193, 301, 277, 40);
		p1.getContentPane().add(t5);

		t6 = new JTextField();
		t6.setFont(new Font("굴림", Font.PLAIN, 30));
		t6.setColumns(30);
		t6.setBounds(193, 380, 277, 40);
		p1.getContentPane().add(t6);

		t7 = new JTextField();
		t7.setFont(new Font("굴림", Font.PLAIN, 30));
		t7.setColumns(30);
		t7.setBounds(193, 448, 277, 40);
		p1.getContentPane().add(t7);

		t8 = new JTextField();
		t8.setToolTipText("예)5");
		t8.setFont(new Font("굴림", Font.PLAIN, 30));
		t8.setColumns(30);
		t8.setBounds(193, 526, 277, 40);
		p1.getContentPane().add(t8);

		t9 = new JTextField();
		t9.setToolTipText("예)30");
		t9.setFont(new Font("굴림", Font.PLAIN, 30));
		t9.setColumns(30);
		t9.setBounds(193, 596, 277, 40);
		p1.getContentPane().add(t9);

		t3 = new JPasswordField();
		t3.setBounds(193, 152, 277, 40);
		p1.getContentPane().add(t3);
		
		JLabel lblQl = new JLabel("비밀번호");
		lblQl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQl.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblQl.setBounds(12, 152, 137, 40);
		p1.getContentPane().add(lblQl);

		p1.setVisible(true);
	}
}
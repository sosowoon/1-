package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {
	private JTextField ID1;
	static String saveId;
	JPasswordField ID2;
	public Login() {
		JFrame f1 = new JFrame();
		f1.setSize(489, 800);
		f1.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 50));
		f1.getContentPane().add(btnNewButton);
		JLabel me = new JLabel("");
		f1.getContentPane().add(me);

		JButton s1 = new JButton("Sing up");
		s1.setSize(489, 800);
		s1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signin2();
				f1.setVisible(false);
			}
		});
		s1.setFont(new Font("굴림", Font.PLAIN, 35));
		s1.setBounds(0, 368, 237, 67);
		f1.getContentPane().add(s1);

		JButton s2 = new JButton("Log in ");
		s2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String id = ID1.getText();
				String pwd = ID2.getText();
				saveId = id;
				MemberDAO dao = new MemberDAO();
				try {
					boolean result = dao.select(id, pwd);
					if (result == true) {
						JOptionPane.showMessageDialog(f1, "환영합니다.");
						new MyInfo();
						
						
						ThreadEX threadex = new ThreadEX();
						Thread thread1 = new Thread(threadex, "A");
						thread1.start();
						Thread.currentThread().getName();
						
						f1.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(f1, "다시 로그인해주세요");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		s2.setFont(new Font("굴림", Font.PLAIN, 35));
		s2.setSize(489, 800);
		s2.setBounds(238, 368, 235, 67);
		f1.getContentPane().add(s2);

		JLabel IDtext = new JLabel("ID ");
		IDtext.setHorizontalAlignment(SwingConstants.CENTER);
		IDtext.setSize(489, 800);
		IDtext.setFont(new Font("굴림", Font.PLAIN, 25));
		IDtext.setBounds(0, 74, 473, 59);
		f1.getContentPane().add(IDtext);

		JLabel PWtext = new JLabel("PW");
		PWtext.setHorizontalAlignment(SwingConstants.CENTER);
		PWtext.setSize(489, 800);
		PWtext.setFont(new Font("굴림", Font.PLAIN, 25));
		PWtext.setBounds(0, 199, 473, 67);
		f1.getContentPane().add(PWtext);

		ID1 = new JTextField();
		ID1.setFont(new Font("굴림", Font.PLAIN, 25));
		ID1.setHorizontalAlignment(SwingConstants.CENTER);
		ID1.setSize(489, 800);
		ID1.setBounds(0, 135, 473, 54);
		f1.getContentPane().add(ID1);
		ID1.setColumns(10);

		ID2 = new JPasswordField();
		ID2.setFont(new Font("굴림", Font.PLAIN, 25));
		ID2.setHorizontalAlignment(SwingConstants.CENTER);
		ID2.setBounds(0, 266, 471, 59);
		f1.getContentPane().add(ID2);
		
		JLabel lblNewLabel = new JLabel("WELCOME to PHC");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 473, 59);
		f1.getContentPane().add(lblNewLabel);
		
		f1.setVisible(true);
	}
}

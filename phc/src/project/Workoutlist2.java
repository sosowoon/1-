package project;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class Workoutlist2 {
	ExerciseDTO dto = null;

	int eid;
	private JTextArea a2;
	JFrame f;

	public Workoutlist2(int eid) {
		this.eid = eid;

///////////////////////////////////////////////////공통시작!!
/////////////////////////상단 메뉴/////////////////////////
		f = new JFrame();
		f.setTitle("Personal Health Care");
		f.setSize(489, 800);
		f.getContentPane().setLayout(null);

		JButton b1 = new JButton("운동");
		b1.setLocation(0, 0);
		b1.setSize(118, 58);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new List();
				f.setVisible(false);
			}
		});
		f.getContentPane().add(b1);

		JButton b2 = new JButton("식단");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Food();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		b2.setBounds(118, 0, 118, 58);
		f.getContentPane().add(b2);

		JButton b3 = new JButton("내정보");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyInfo();
				f.setVisible(false);
			}
		});
		b3.setBounds(236, 0, 118, 58);
		f.getContentPane().add(b3);

		JButton b4 = new JButton("로그아웃");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login.saveId = null;
					JOptionPane.showMessageDialog(f, "로그아웃되었습니다.");
					new Login();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		b4.setBounds(354, 0, 118, 58);
		f.getContentPane().add(b4);
/////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////공통끝!!

		ExerciseDAO dao = new ExerciseDAO();
		try {
			dto = dao.select(eid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel a1 = new JLabel(dto.getEname());
		a1.setFont(new Font("굴림", Font.PLAIN, 30));
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setBounds(0, 65, 472, 42);
		f.getContentPane().add(a1);

		JTextField a4 = new JTextField();
		a4.setFont(new Font("굴림", Font.PLAIN, 30));
		a4.setColumns(10);
		a4.setBounds(196, 474, 276, 53);
		f.getContentPane().add(a4);

		ImageIcon img = new ImageIcon(dto.getImg());
		JLabel walkingimage = new JLabel("");
		walkingimage.setIcon(img);

		walkingimage.setBounds(0, 119, 472, 170);
		f.getContentPane().add(walkingimage);

		JTextField t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		a2 = new JTextArea(dto.getContents().replace("  ", "\n"));
		a2.setMargin(new Insets(7, 7, 7, 7));
		a2.setLineWrap(true);
		a2.setBounds(0, 299, 472, 119);
		f.getContentPane().add(a2);
		a2.setColumns(10);

		JTextField a3 = new JTextField();
		a3.setFont(new Font("굴림", Font.PLAIN, 30));
		a3.setColumns(10);
		a3.setBounds(196, 419, 276, 53);
		f.getContentPane().add(a3);

		JTextField a5 = new JTextField();
		a5.setFont(new Font("굴림", Font.PLAIN, 30));
		a5.setColumns(10);
		a5.setBounds(196, 589, 276, 53);
		f.getContentPane().add(a5);

		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List cancer = new List();
				f.setVisible(false);
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 30));
		button.setBounds(262, 652, 170, 58);
		f.getContentPane().add(button);

		JButton btnNewButton = new JButton("선택완료");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int mul1 = Integer.parseInt(a3.getText());
				int mul2 = Integer.parseInt(a4.getText());
				int mul3 = Integer.parseInt(a5.getText());

				double sum = mul1 * 0.1 + mul2 * 0.6 + mul3 * 0.1;
				// double --> String
				int cal = dto.geteCal();
				int amount = (int) (sum * cal);
				a5.setText(String.valueOf(amount)); // double --> string 으로 변환시키는 코드
				try {
					MyExerDAO dao2 = new MyExerDAO();
					MyExerDTO dto = new MyExerDTO();
					dto.setAmount(amount); // amount
					System.out.println("////////" + Login.saveId);

					dto.setId(Login.saveId); // test
					dto.setEid(eid); // eid
					Date date = new Date(); // date
					dto.setDate(new java.sql.Date(date.getTime()));

					dao2.insert(dto);
					new List();
					f.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(36, 652, 170, 58);
		f.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("reps");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(10, 423, 170, 41);
		f.getContentPane().add(lblNewLabel_1);

		JLabel lblSet = new JLabel("Set");
		lblSet.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblSet.setBounds(10, 478, 170, 41);
		f.getContentPane().add(lblSet);

		JButton answer = new JButton("계산");
		answer.setFont(new Font("굴림", Font.PLAIN, 30));
		answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int kcal1 = Integer.parseInt(a3.getText());
				int kcal2 = Integer.parseInt(a4.getText());

				double sum = (kcal1 * 0.1) + (kcal2 * 0.6); // 임의 설정값

				// double --> String
				int cal = dto.geteCal();
				a5.setText(String.valueOf((int) (sum * cal))); // double --> string 으로 변환시키는 코드

			}
		});
		answer.setBounds(6, 537, 466, 48);
		f.getContentPane().add(answer);

		JLabel lblKcal = new JLabel("Kcal");
		lblKcal.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblKcal.setBounds(10, 595, 170, 41);
		f.getContentPane().add(lblKcal);

		f.setVisible(true);

	}
}

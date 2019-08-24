package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Insets;

public class Workoutlist {
	private JTextArea t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	ExerciseDTO dto = null;
	int eid;
	JFrame f;
	public Workoutlist(int eid) {
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
			e1.printStackTrace();
		}

		JLabel kind = new JLabel(dto.getEname());
		kind.setFont(new Font("굴림", Font.PLAIN, 30));
		kind.setHorizontalAlignment(SwingConstants.CENTER);
		kind.setBounds(0, 57, 472, 41);
		f.getContentPane().add(kind);

		JButton summit = new JButton("선택완료");
		summit.setFont(new Font("굴림", Font.PLAIN, 30));
		summit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new List();
				f.setVisible(false);
			}
		});
		summit.setBounds(44, 701, 170, 58);
		f.getContentPane().add(summit);

		ImageIcon img = new ImageIcon(dto.getImg());
		JLabel image = new JLabel("");
		image.setIcon(img);
		image.setBounds(0, 101, 472, 166);
		f.getContentPane().add(image);

		t1 = new JTextArea(dto.getContents().replace("  ", "\n"));
		t1.setMargin(new Insets(7, 7, 7, 7));
		t1.setBounds(new Rectangle(10, 10, 10, 10));
		t1.setLineWrap(true);
		
		t1.setBounds(0, 277, 472, 119);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		t1.setLineWrap(true);

		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List name = new List();
				f.setVisible(false);
			}
		});
		cancel.setFont(new Font("굴림", Font.PLAIN, 30));
		cancel.setBounds(272, 701, 170, 58);
		f.getContentPane().add(cancel);

		JLabel lblDistance = new JLabel("distance");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblDistance.setBounds(44, 398, 151, 41);
		f.getContentPane().add(lblDistance);

		JLabel lblTime = new JLabel("time");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTime.setToolTipText("s");
		lblTime.setBounds(44, 459, 151, 41);
		f.getContentPane().add(lblTime);

		JLabel lblSpeed = new JLabel("speed");
		lblSpeed.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSpeed.setBounds(44, 519, 151, 41);
		f.getContentPane().add(lblSpeed);

		JLabel lblKacl = new JLabel("kcal");
		lblKacl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblKacl.setBounds(44, 650, 151, 41);
		f.getContentPane().add(lblKacl);

		t2 = new JTextField();
		t2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t2.setBounds(232, 399, 210, 41);
		f.getContentPane().add(t2);
		t2.setColumns(10);

		t3 = new JTextField();
		t3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t3.setColumns(10);
		t3.setBounds(232, 459, 210, 41);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t4.setColumns(10);
		t4.setBounds(232, 519, 210, 41);
		f.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t5.setColumns(10);
		t5.setBounds(137, 645, 305, 41);
		f.getContentPane().add(t5);

		JButton answer = new JButton("계산");
		answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int mul1 = Integer.parseInt(t2.getText());
				int mul2 = Integer.parseInt(t3.getText());
				int mul3 = Integer.parseInt(t4.getText());

				double sum = mul1 * 0.1 + mul2 * 0.6 + mul3 * 0.1;
				// double --> String
				int cal = dto.geteCal();
				int amount = (int) (sum * cal);
				t5.setText(String.valueOf(amount)); // double --> string 으로 변환시키는 코드
				try {
					MyExerDAO dao2 = new MyExerDAO();
					MyExerDTO dto = new MyExerDTO();
					dto.setAmount(amount); // amount

					dto.setId(Login.saveId); // test
					dto.setEid(eid); // eid
					Date date = new Date(); // date
					dto.setDate(new java.sql.Date(date.getTime()));

					dao2.insert(dto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		answer.setFont(new Font("Dialog", Font.PLAIN, 30));
		answer.setBounds(44, 579, 398, 41);
		f.getContentPane().add(answer);

		f.setVisible(true);
	}
}

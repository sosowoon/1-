package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

public class Workoutlist {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	int eid;
    
	public Workoutlist(int eid) {
		this.eid = eid;
	
		
		
		
		JFrame f = new JFrame();
		f.setTitle("Personal Health Care");
		f.setSize(489, 800);
		f.getContentPane().setLayout(null);

		JButton b1 = new JButton("운동");
		b1.setLocation(6, 6);
		b1.setSize(118, 58);

		f.getContentPane().add(b1);

		JButton b2 = new JButton("식단");
		b2.setBounds(137, 6, 118, 58);
		f.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Food();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});

		JButton b3 = new JButton("내정보");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyInfo();
			}
		});
		b3.setBounds(257, 6, 118, 58);
		f.getContentPane().add(b3);

		JButton b4 = new JButton("로그아웃");
		b4.setBounds(387, 6, 118, 58);
		f.getContentPane().add(b4);

		ExerciseDAO dao = new ExerciseDAO();
		ExerciseDTO dto = null;
		try {
			dto = dao.select(eid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

//		JLabel kind = new JLabel(dto.getKind());
		JLabel kind = new JLabel();
		kind.setFont(new Font("굴림", Font.PLAIN, 30));
		kind.setHorizontalAlignment(SwingConstants.CENTER);
		kind.setBounds(16, 77, 472, 41);
		f.getContentPane().add(kind);

		JButton summit = new JButton("선택완료");
		summit.setFont(new Font("굴림", Font.PLAIN, 30));
		summit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new MyInfo();
				f.setVisible(false);
			}
		});
		summit.setBounds(6, 688, 170, 58);
		f.getContentPane().add(summit);

		System.out.println(dto.getImg() + "**********");
		ImageIcon img = new ImageIcon(dto.getImg());
		JLabel image = new JLabel("New label");
		image.setIcon(img);
		image.setBounds(6, 88, 472, 173);
		f.getContentPane().add(image);

		t1 = new JTextField(dto.getContents());
		
		
		
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setBounds(6, 277, 472, 119);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List name = new List();
				f.setVisible(false);
			}
		});
		cancel.setFont(new Font("굴림", Font.PLAIN, 30));
		cancel.setBounds(272, 688, 170, 58);
		f.getContentPane().add(cancel);

		JLabel lblDistance = new JLabel("distance");
		lblDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblDistance.setBounds(44, 408, 151, 41);
		f.getContentPane().add(lblDistance);

		JLabel lblTime = new JLabel("time");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTime.setToolTipText("s");
		lblTime.setBounds(44, 479, 151, 41);
		f.getContentPane().add(lblTime);

		JLabel lblSpeed = new JLabel("speed");
		lblSpeed.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSpeed.setBounds(44, 544, 151, 41);
		f.getContentPane().add(lblSpeed);

		JLabel lblKacl = new JLabel("kacl");
		lblKacl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblKacl.setBounds(44, 613, 151, 41);
		f.getContentPane().add(lblKacl);

		t2 = new JTextField();
		t2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t2.setBounds(257, 409, 185, 50);
		f.getContentPane().add(t2);
		t2.setColumns(10);

		t3 = new JTextField();
		t3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t3.setColumns(10);
		t3.setBounds(257, 474, 185, 50);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t4.setColumns(10);
		t4.setBounds(257, 539, 185, 50);
		f.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		t5.setColumns(10);
		t5.setBounds(257, 608, 185, 50);
		f.getContentPane().add(t5);

		f.setVisible(true);
	}
}

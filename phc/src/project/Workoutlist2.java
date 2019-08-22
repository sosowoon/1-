package project;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Workoutlist2 {

	
	
	int eid;
	public Workoutlist2(int eid) {
		this.eid = eid;

	
		
		JFrame f = new JFrame();
		f.setSize(665, 834);
		f.getContentPane().setLayout(null);

		JButton b1 = new JButton("운동");
		b1.setLocation(0, 6);
		b1.setSize(118, 58);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new List();
				f.setVisible(false);
			}
		});
		f.getContentPane().add(b1);

		JButton b2 = new JButton("식단");
		b2.setBounds(117, 6, 118, 58);
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
		b3.setBounds(234, 6, 118, 58);
		f.getContentPane().add(b3);

		JButton b4 = new JButton("로그아웃");
		b4.setBounds(354, 6, 118, 58);
		f.getContentPane().add(b4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 76, 472, 41);
		f.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("선택완료");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MyInfo main = new MyInfo();
				f.setVisible(false);
			}
		});
		btnNewButton.setBounds(34, 717, 170, 58);
		f.getContentPane().add(btnNewButton);

		JTextField txtTime = new JTextField();
		txtTime.setFont(new Font("굴림", Font.PLAIN, 30));
		txtTime.setColumns(10);
		txtTime.setBounds(192, 488, 280, 53);
		f.getContentPane().add(txtTime);

		
		
		ExerciseDAO dao = new ExerciseDAO();
		ExerciseDTO dto = null;
		try {
			dto = dao.select(eid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(dto.getImg()+"**********");
		ImageIcon img = new ImageIcon(dto.getImg());	
		JLabel walkingimage = new JLabel("New label");
		walkingimage.setIcon(img);
		
		
		walkingimage.setBounds(0, 99, 472, 170);
		f.getContentPane().add(walkingimage);

		
		
		
		JTextField t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1 = new JTextField(dto.getContents());
		t1.setBounds(0, 281, 472, 119);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JTextField txtDistance = new JTextField();
		txtDistance.setFont(new Font("굴림", Font.PLAIN, 30));
		txtDistance.setColumns(10);
		txtDistance.setBounds(192, 412, 276, 53);
		f.getContentPane().add(txtDistance);

		JTextField txtKcal = new JTextField();
		txtKcal.setFont(new Font("굴림", Font.PLAIN, 30));
		txtKcal.setText("Kcal:");
		txtKcal.setColumns(10);
		txtKcal.setBounds(0, 642, 472, 53);
		f.getContentPane().add(txtKcal);

		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List cancer = new List();
				f.setVisible(false);
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 30));
		button.setBounds(260, 717, 170, 58);
		f.getContentPane().add(button);

		JLabel lblNewLabel_1 = new JLabel("reps");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(0, 416, 170, 41);
		f.getContentPane().add(lblNewLabel_1);

		JLabel lblSet = new JLabel("Set");
		lblSet.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblSet.setBounds(0, 492, 170, 41);
		f.getContentPane().add(lblSet);
		
		JButton btnNewButton_1 = new JButton("버튼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(6, 564, 466, 48);
		f.getContentPane().add(btnNewButton_1);

		f.setVisible(true);

	}
}

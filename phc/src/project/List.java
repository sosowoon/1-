

package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

public class List {

	public List() {
		JFrame f = new JFrame();
		f.setTitle("Personal Health Care");
		f.setSize(489,800);
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

		JLabel lblNewLabel = new JLabel("유산소");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 68, 472, 38);
		f.getContentPane().add(lblNewLabel);

		JButton t1 = new JButton("1. Walking");
		t1.setFont(new Font("굴림", Font.PLAIN, 30));

		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist you = new Workoutlist(1);
				f.setVisible(false);
			}
		});

		t1.setBounds(0, 105, 472, 63);
		ImageIcon icon = new ImageIcon("walking.png");
		Image image = icon.getImage();
		Image img = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img);
		t1.setIcon(icon2);

		f.getContentPane().add(t1);

		JLabel label = new JLabel("무산소");
		label.setFont(new Font("굴림", Font.PLAIN, 40));
		label.setBounds(0, 408, 472, 38);
		f.getContentPane().add(label);

		JButton t2 = new JButton("2. Running");
		t2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Workoutlist you = new Workoutlist(2);
				f.setVisible(false);
			}
		});
		t2.setFont(new Font("굴림", Font.PLAIN, 30));
		t2.setBounds(0, 163, 472, 63);
		f.getContentPane().add(t2);

		ImageIcon icon3 = new ImageIcon("running.png");
		Image image2 = icon3.getImage();
		Image img2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon4 = new ImageIcon(img2);
		t2.setIcon(icon4);

		JButton t3 = new JButton("3. Scoccer");
		t3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Workoutlist you = new Workoutlist(3);
				f.setVisible(false);
			}
		});
		t3.setFont(new Font("굴림", Font.PLAIN, 30));
		t3.setBounds(0, 224, 472, 63);
		f.getContentPane().add(t3);

		ImageIcon icon6 = new ImageIcon("soccer.png");
		Image image3 = icon6.getImage();
		Image img3 = image3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon7 = new ImageIcon(img3);
		t3.setIcon(icon7);

		JButton t4 = new JButton("4. Basketball");
		t4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist you = new Workoutlist(4);
				
			}
		});

		ImageIcon icon8 = new ImageIcon("basketball.png");
		Image image4 = icon8.getImage();
		Image img4 = image4.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon9 = new ImageIcon(img4);
		t4.setIcon(icon9);

		t4.setFont(new Font("굴림", Font.PLAIN, 30));
		t4.setBounds(0, 283, 472, 63);
		f.getContentPane().add(t4);

		JButton t5 = new JButton("5. Swimming");
		t5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist you = new Workoutlist(5);
			
				f.setVisible(false);
			}
		});
		t5.setFont(new Font("굴림", Font.PLAIN, 30));
		t5.setBounds(0, 344, 472, 63);
		f.getContentPane().add(t5);

		ImageIcon icon10 = new ImageIcon("swimming.png");
		Image image5 = icon10.getImage();
		Image img5 = image5.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon11 = new ImageIcon(img5);
		t5.setIcon(icon11);

		JButton t6 = new JButton("1. Bench press");
		t6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist2 you = new Workoutlist2(6);
				
				f.setVisible(false);
			}
		});

		ImageIcon icon12 = new ImageIcon("bencbh.png");
		Image image6 = icon12.getImage();
		Image img6 = image6.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon13 = new ImageIcon(img6);
		t6.setIcon(icon13);

		t6.setFont(new Font("굴림", Font.PLAIN, 30));
		t6.setBounds(0, 449, 472, 63);
		f.getContentPane().add(t6);

		JButton t7 = new JButton("2. Squat");
		t7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Workoutlist2 you = new Workoutlist2(7);
				f.setVisible(false);
			}
		});

		ImageIcon icon14 = new ImageIcon("squat.png");
		Image image7 = icon14.getImage();
		Image img7 = image7.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon15 = new ImageIcon(img7);
		t7.setIcon(icon15);

		t7.setFont(new Font("굴림", Font.PLAIN, 30));
		t7.setBounds(0, 508, 472, 63);
		f.getContentPane().add(t7);

		JButton t8 = new JButton("3. Deadlift");
		t8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist2 you = new Workoutlist2(8);
			
				f.setVisible(false);
			}
		});

		ImageIcon icon16 = new ImageIcon("deadlift.png");
		Image image8 = icon16.getImage();
		Image img8 = image8.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon17 = new ImageIcon(img8);
		t8.setIcon(icon17);

		t8.setFont(new Font("굴림", Font.PLAIN, 30));
		t8.setBounds(0, 568, 472, 63);
		f.getContentPane().add(t8);

		JButton t9 = new JButton("4. Push up");
		t9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Workoutlist2 you = new Workoutlist2(9);
			
				f.setVisible(false);
			}
		});
		ImageIcon icon18 = new ImageIcon("push up.png");
		Image image9 = icon18.getImage();
		Image img9 = image9.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon19 = new ImageIcon(img9);
		t9.setIcon(icon19);

		t9.setFont(new Font("굴림", Font.PLAIN, 30));
		t9.setBounds(0, 626, 472, 63);
		f.getContentPane().add(t9);

		JButton t10 = new JButton("5. Sit up");
		t10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Workoutlist2 you = new Workoutlist2(10);
			
				f.setVisible(false);
			}
		});

		ImageIcon icon20 = new ImageIcon("sit up.png");
		Image image10 = icon20.getImage();
		Image img10 = image10.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon21 = new ImageIcon(img10);
		t10.setIcon(icon21);

		t10.setFont(new Font("굴림", Font.PLAIN, 30));
		t10.setBounds(0, 688, 472, 63);
		f.getContentPane().add(t10);

		f.setVisible(true);

	}
}

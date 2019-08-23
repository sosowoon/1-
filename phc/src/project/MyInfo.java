package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.UIManager;

public class MyInfo implements ActionListener {
	JDateChooser dateChooser;
	JFrame f;
	JScrollPane scroll;
	MyExerDAO dao3;
	String result;
	ArrayList<MyExerDTO> listMyexer;
	JButton[] btn;
	JLabel l2;
	
	public MyInfo() {
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
		
		JLabel l1 = new JLabel("목표 칼로리    " + "   섭취 칼로리   " + "      소모칼로리    " + "       남은칼로리   ");
		l1.setBackground(Color.WHITE);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(0, 58, 472, 48);
		f.getContentPane().add(l1);

		l2 = new JLabel();
		l2.setBackground(Color.WHITE);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(0, 108, 472, 48);
		f.getContentPane().add(l2);
		recountKcal();

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		f.getContentPane().add(panel);
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("굴림", Font.BOLD, 15));
		dateChooser.setBounds(0, 166, 246, 48);
		JTextFieldDateEditor dateEditor = (JTextFieldDateEditor) dateChooser.getComponent(1);
		dateEditor.setHorizontalAlignment(JTextField.CENTER);

		dateChooser.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {

			}
		});
		f.getContentPane().add(dateChooser);

		JButton bSearch = new JButton("조회하기");
		bSearch.setBounds(244, 166, 228, 48);
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
				try {
					if (scroll != null) {
						f.remove(scroll);
					}

					setListAll(sqldate);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		f.getContentPane().add(bSearch);
		try {
			setListAll(new java.sql.Date(dateChooser.getDate().getTime()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		f.setVisible(true);
	}

	public void setListAll(Date date) throws Exception {
		scroll = new JScrollPane();
		scroll.setBounds(0, 214, 472, 549);
		f.getContentPane().add(scroll);

		JPanel panel = new JPanel();
		scroll.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel columnpanel = new JPanel();
		panel.add(columnpanel, BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
		columnpanel.setBackground(Color.gray);

		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(bSet, 28);

		JTextPane title1 = new JTextPane();
		title1.setPreferredSize(new Dimension(472, 41));
		title1.setBackground(new Color(0, 191, 255));
		title1.setText("내 식단 리스트");
		StyledDocument docT1 = title1.getStyledDocument();
		docT1.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(title1);

		JTextPane tM = new JTextPane();
		tM.setPreferredSize(new Dimension(472, 41));
		tM.setBackground(new Color(255, 250, 205));
		tM.setText("아침");

		StyledDocument doc1 = tM.getStyledDocument();
		doc1.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tM);
		MyDietDAO dao = new MyDietDAO();
		ArrayList<MyDietDTO> listM = dao.select(0, date, Login.saveId);
		for (int i = 0; i < listM.size(); i++) {
			MyDietDTO dto1 = listM.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ " + dto2.getDname() + ">>총칼:" + dto2.getDcal() + " >>탄:" + dto2.getCarb()
					+ " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat() + ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);
		}
		
		JTextPane tL = new JTextPane();
		tL.setPreferredSize(new Dimension(472, 41));
		tL.setBackground(new Color(245, 245, 220));
		tL.setText("점심");
		StyledDocument doc2 = tL.getStyledDocument();
		doc2.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tL);
		ArrayList<MyDietDTO> listL = dao.select(1, date, Login.saveId);
		for (int i = 0; i < listL.size(); i++) {
			MyDietDTO dto1 = listL.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ " + dto2.getDname() + ">>총칼:" + dto2.getDcal() + " >>탄:" + dto2.getCarb()
					+ " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat() + ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);
		}

		JTextPane tD = new JTextPane();
		tD.setPreferredSize(new Dimension(472, 41));
		tD.setBackground(new Color(244, 164, 96));
		tD.setText("저녁");
		StyledDocument doc3 = tD.getStyledDocument();
		doc3.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tD);
		ArrayList<MyDietDTO> listD = dao.select(2, date, Login.saveId);
		for (int i = 0; i < listD.size(); i++) {
			MyDietDTO dto1 = listD.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ " + dto2.getDname() + ">>총칼:" + dto2.getDcal() + " >>탄:" + dto2.getCarb()
					+ " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat() + ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);
		}

		JTextPane tS = new JTextPane();
		tS.setPreferredSize(new Dimension(472, 41));
		tS.setBackground(new Color(250, 128, 114));
		tS.setText("간식");
		StyledDocument doc4 = tS.getStyledDocument();
		doc4.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tS);
		ArrayList<MyDietDTO> listS = dao.select(3, date, Login.saveId);
		for (int i = 0; i < listS.size(); i++) {
			MyDietDTO dto1 = listS.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ " + dto2.getDname() + ">>총칼:" + dto2.getDcal() + " >>탄:" + dto2.getCarb()
					+ " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat() + ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);
		}

		JTextPane title2 = new JTextPane();
		title2.setPreferredSize(new Dimension(472, 41));
		title2.setBackground(new Color(0, 191, 255));
		title2.setText("내 운동 리스트");
		StyledDocument docT2 = title2.getStyledDocument();
		docT2.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(title2);

		MyExerDAO dao3 = new MyExerDAO();
		listMyexer = dao3.selectAll(date, Login.saveId);

		JLabel[] label = new JLabel[listMyexer.size()];
		btn = new JButton[listMyexer.size()];

		for (int i = 0; i < listMyexer.size(); i++) {
			JPanel rowPanel = new JPanel();
			MyExerDTO dto1 = listMyexer.get(i);
			ExerciseDAO dao2 = new ExerciseDAO();
			ExerciseDTO dto2 = dao2.select(dto1.getEid());
			label[i] = new JLabel("○ " + dto2.getEname() + "  >>총소모칼로리:" + dto1.getAmount());
			label[i].setPreferredSize(new Dimension(360, 41));
			rowPanel.add(label[i]);
			if (dto1.isResult() == true) {
				result = "Done";
			} else if (dto1.isResult() == false) {
				result = "Notyet";
			}
			btn[i] = new JButton(result);
			btn[i].setPreferredSize(new Dimension(60, 45));
			btn[i].addActionListener(this);
			btn[i].setMargin(new Insets(0, 0, 0, 0));
			rowPanel.add(btn[i]);
			columnpanel.add(rowPanel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyExerDAO dao = new MyExerDAO();
		for (int i = 0; i < listMyexer.size(); i++) {
			if (e.getSource() == btn[i]) {
				if (btn[i].getText().equals("Done")) {
					btn[i].setText("Notyet");
					try {
						dao.update(listMyexer.get(i).getMyeid(), false);
						recountKcal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (btn[i].getText().equals("Notyet")) {
					btn[i].setText("Done");
					try {
						dao.update(listMyexer.get(i).getMyeid(), true);
						recountKcal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	public void recountKcal() {
		try {
			MemberDAO memberdao = new MemberDAO();
			MemberDTO memberdto = memberdao.selectKcal(Login.saveId);
			int lKcal = memberdto.getLkcal();

			int inKcal = 0;
			MyDietDAO mydietdao = new MyDietDAO();
			java.util.Date date = new java.util.Date();
			Date sqldate = new Date(date.getTime());
			ArrayList<MyDietDTO> mydietlist = mydietdao.selectTcal(sqldate, Login.saveId);
			for (int i = 0; i < mydietlist.size(); i++) {
				MyDietDTO dto1 = mydietlist.get(i);
				DietDAO dao2 = new DietDAO();
				DietDTO dto2 = dao2.select(dto1.getDid());
				int cal = dto2.getDcal() * dto1.getAmount();
				inKcal += cal;
			}

			int outKcal = 0;
			MyExerDAO myexerdao =  new MyExerDAO();
			ArrayList<MyExerDTO> list = myexerdao.select(sqldate, Login.saveId , true);
			for (int i = 0; i < list.size(); i++) {
				MyExerDTO dto1 = list.get(i);
				outKcal += dto1.getAmount();
			} 
			l2.setText(lKcal + "kcal       =        " + inKcal + "kcal        -        " + outKcal
					+ "kcal        +      " + (lKcal-(inKcal-outKcal)) + "kcal");
			f.setVisible(true);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}

package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class FoodChoice implements ActionListener{
	JLabel[] innerL;
	JButton[] innerB1;
	JTextField[] innerT;
	JButton[] innerB2;
	ArrayList<DietDTO> list;
	JLabel l2;
	JFrame f;
	public FoodChoice() throws Exception {
		/////////////////////////////////////////////////// 공통시작!!
		///////////////////////// 상단 메뉴/////////////////////////
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
		///////////////////// 실시간 칼로리 계산//////////////////////
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
		//////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////// 공통끝!!
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 159,472, 550);
		f.getContentPane().add(scroll);
		
		JPanel panel = new JPanel();
		scroll.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel columnpanel = new JPanel();
		panel.add(columnpanel, BorderLayout.NORTH);
        columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
        columnpanel.setBackground(Color.gray);	
		
		DietDAO db = new DietDAO();
		list = db.selectAll();
		
		innerL = new JLabel[list.size()];
		innerB1 = new JButton[list.size()];
		innerT = new JTextField[list.size()];
		innerB2 = new JButton[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			DietDTO dto = list.get(i);
			JPanel rowPanel = new JPanel();
			innerL[i] = new JLabel("○ "+dto.getDname() + ">>총칼:" + dto.getDcal() + " >>탄:" + dto.getCarb() + " >>단:" + dto.getProt() + " >>지:" + dto.getFat());
			innerL[i].setPreferredSize(new Dimension(310, 45));
			rowPanel.add(innerL[i]);
			innerB1[i] = new JButton("<");
			innerB1[i].setPreferredSize(new Dimension(40, 45));
			innerB1[i].addActionListener(this);
			innerB1[i].setMargin(new Insets(0, 0, 0, 0)); 
			rowPanel.add(innerB1[i]);
			innerT[i] = new JTextField("0");
			innerT[i].setHorizontalAlignment(SwingConstants.CENTER);
			innerT[i].setPreferredSize(new Dimension(45, 45));
			rowPanel.add(innerT[i]);
			innerB2[i] = new JButton(">");
			innerB2[i].setPreferredSize(new Dimension(40, 45));
			innerB2[i].addActionListener(this);
			innerB2[i].setMargin(new Insets(0, 0, 0, 0)); 
			rowPanel.add(innerB2[i]);
			columnpanel.add(rowPanel);
		}
		
		JButton bC = new JButton("선택완료");
		bC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					DietDTO dto = list.get(i);
					if(Integer.parseInt(innerT[i].getText())>0){
						try {
							MyDietDAO db = new MyDietDAO();
							MyDietDTO dto1 = new MyDietDTO();
							dto1.setAmount(Integer.parseInt(innerT[i].getText()));
							Date date = new Date();
							dto1.setDate(new java.sql.Date(date.getTime()));
							dto1.setId(Login.saveId);
							dto1.setDid(dto.getDid());
							dto1.setTime(Food.time);
							db.insert(dto1);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				try {
					new Food();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		
		bC.setBounds(0, 699, 472, 62);
		f.getContentPane().add(bC);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < list.size(); i++) {
			if(e.getSource() == innerB1[i]) {
				if(Integer.parseInt(innerT[i].getText())>0){
					innerT[i].setText(String.valueOf(Integer.parseInt(innerT[i].getText())-1));
				}
			}else if(e.getSource() == innerB2[i]) {
				innerT[i].setText(String.valueOf(Integer.parseInt(innerT[i].getText())+1));
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
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
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

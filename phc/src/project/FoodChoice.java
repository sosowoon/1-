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
	public FoodChoice() throws Exception {
		/////////////////////////////////////////////////// 공통시작!!
		///////////////////////// 상단 메뉴/////////////////////////
		JFrame f = new JFrame();
		
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
		b4.setBounds(354, 0, 118, 58);
		f.getContentPane().add(b4);
		/////////////////////////////////////////////////////////////
		///////////////////// 실시간 칼로리 계산//////////////////////
		JLabel l1 = new JLabel("남은 칼로리");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(0, 58, 472, 48);
		f.getContentPane().add(l1);

		JLabel l2 = new JLabel("DB에서 칼로리 가져와서 계산하기(실시간)");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(0, 108, 472, 48);
		f.getContentPane().add(l2);
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
							dto1.setId(Login.id);
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
	
}

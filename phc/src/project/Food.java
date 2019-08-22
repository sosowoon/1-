package project;

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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Food implements ActionListener{
	JFrame f;
	static int time;
	JButton bM, bL, bD, bS;
	public Food() throws Exception {
		///////////////////////////////////////////////////공통시작!!
		/////////////////////////상단 메뉴/////////////////////////
		f = new JFrame();
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
		/////////////////////실시간 칼로리 계산//////////////////////
		JLabel l1 = new JLabel("남은 칼로리");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(0, 58, 472, 48);
		f.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("DB에서 칼로리 가져와서 계산하기(실시간)");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(0, 108, 472, 48);
		f.getContentPane().add(l2);
		//////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////공통끝!!
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 158, 472, 593);
		f.getContentPane().add(scroll);
		
		JPanel panel = new JPanel();
		scroll.setViewportView(panel);
		panel.setLayout(new BorderLayout(0,0));
		
		JPanel columnpanel = new JPanel();
		panel.add(columnpanel,BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
        columnpanel.setBackground(Color.gray);
		
		JTextPane tM = new JTextPane();
		tM.setPreferredSize(new Dimension(472, 41));
		tM.setBackground(Color.PINK);
		tM.setText("아침");
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(bSet, 28);
		StyledDocument doc1 = tM.getStyledDocument();
		doc1.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tM);
		MyDietDAO dao = new MyDietDAO();
		Date date = new Date();
		ArrayList<MyDietDTO> listM = dao.select(0, new java.sql.Date(date.getTime()),Login.id);
		for (int i = 0; i < listM.size(); i++) {
			MyDietDTO dto1 = listM.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ "+dto2.getDname() + ">>총칼:" + dto2.getDcal() 
										+ " >>탄:" + dto2.getCarb() + " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat()
										+ ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);			
		}
		
		bM = new JButton("+");
		bM.setPreferredSize(new Dimension(472, 41));
		columnpanel.add(bM);
		
		JTextPane tL = new JTextPane();
		tL.setPreferredSize(new Dimension(472, 41));
		tL.setBackground(Color.PINK);
		tL.setText("점심");
		StyledDocument doc2 = tL.getStyledDocument();
		doc2.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tL);
		ArrayList<MyDietDTO> listL = dao.select(1, new java.sql.Date(date.getTime()),Login.id);
		for (int i = 0; i < listL.size(); i++) {
			MyDietDTO dto1 = listL.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ "+dto2.getDname() + ">>총칼:" + dto2.getDcal() 
										+ " >>탄:" + dto2.getCarb() + " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat()
										+ ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);			
		}
		bL = new JButton("+");
		bL.setPreferredSize(new Dimension(472, 41));
		columnpanel.add(bL);
		
		JTextPane tD = new JTextPane();
		tD.setPreferredSize(new Dimension(472, 41));
		tD.setBackground(Color.PINK);
		tD.setText("저녁");
		StyledDocument doc3 = tD.getStyledDocument();
		doc3.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tD);
		ArrayList<MyDietDTO> listD = dao.select(2, new java.sql.Date(date.getTime()),Login.id);
		for (int i = 0; i < listD.size(); i++) {
			MyDietDTO dto1 = listD.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ "+dto2.getDname() + ">>총칼:" + dto2.getDcal() 
										+ " >>탄:" + dto2.getCarb() + " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat()
										+ ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);			
		}
		bD = new JButton("+");
		bD.setPreferredSize(new Dimension(472, 41));
		columnpanel.add(bD);
		
		JTextPane tS = new JTextPane();
		tS.setPreferredSize(new Dimension(472, 41));
		tS.setBackground(Color.PINK);
		tS.setText("간식");
		StyledDocument doc4 = tS.getStyledDocument();
		doc4.setParagraphAttributes(0, 104, bSet, false);
		columnpanel.add(tS);
		ArrayList<MyDietDTO> listS = dao.select(3, new java.sql.Date(date.getTime()),Login.id);
		for (int i = 0; i < listS.size(); i++) {
			MyDietDTO dto1 = listS.get(i);
			DietDAO dao2 = new DietDAO();
			DietDTO dto2 = dao2.select(dto1.getDid());
			JLabel label = new JLabel("○ "+dto2.getDname() + ">>총칼:" + dto2.getDcal() 
										+ " >>탄:" + dto2.getCarb() + " >>단:" + dto2.getProt() + " >>지:" + dto2.getFat()
										+ ">>개수:" + dto1.getAmount());
			label.setPreferredSize(new Dimension(472, 41));
			columnpanel.add(label);			
		}
		bS = new JButton("+");
		bS.setPreferredSize(new Dimension(472, 41));
		columnpanel.add(bS);
		
		bM.addActionListener(this);
		bL.addActionListener(this);
		bD.addActionListener(this);
		bS.addActionListener(this);
		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == bM) {
				time = 0;
			}else if(e.getSource() == bL){
				time = 1;
			}else if(e.getSource() == bD){
				time = 2;
			}else {
				time = 3;
			}
			new FoodChoice();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		f.setVisible(false);
	}
}

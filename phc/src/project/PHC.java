package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

public class PHC {
	private static JTextField txtMyPersonalHealth;

	public static void main(String[] args) throws Exception {
		JFrame F = new JFrame();

		F.setSize(489, 800);
		JButton me = new JButton("나를 눌러.");
		ImageIcon icon = new ImageIcon("Logo.png");
		Image image2age = icon.getImage();
		Image img = image2age.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img);
		me.setIcon(icon2);
		me.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				F.setVisible(false);
			}
		});

		F.getContentPane().add(me);

		txtMyPersonalHealth = new JTextField();
		txtMyPersonalHealth.setFont(new Font("굴림", Font.PLAIN, 40));
		txtMyPersonalHealth.setText("my personal health care");
		F.getContentPane().add(txtMyPersonalHealth, BorderLayout.NORTH);
		txtMyPersonalHealth.setColumns(10);

		F.setVisible(true);
	}

}

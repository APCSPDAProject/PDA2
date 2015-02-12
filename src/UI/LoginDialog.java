package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;



public class LoginDialog extends JFrame  {
	
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JTextField userNameField;
	public JButton Submit;
	public JButton NewAcount;

	public LoginDialog(){
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		
		userNameField = new javax.swing.JTextField();
		
		passwordField = new javax.swing.JPasswordField();
		
		
		jLabel3 = new javax.swing.JLabel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setPreferredSize(new Dimension(370, 200));
		getContentPane().setLayout(null);

		jLabel1.setText("Username:");
		jLabel1.setForeground(new Color(200, 200, 200));
		getContentPane().add(jLabel1);
		jLabel1.setBounds(70, 60, 52, 14);

		jLabel2.setText("Password:");
		jLabel2.setForeground(new Color(200, 200, 200));
		getContentPane().add(jLabel2);
		jLabel2.setBounds(70, 110, 50, 14);

		userNameField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//userNameFieldActionPerformed(evt);
			}
		});
		getContentPane().add(userNameField);
		userNameField.setBounds(160, 60, 150, 25);
		userNameField.setText(StartupMessages.StartupNames[new Random().nextInt(StartupMessages.StartupNames.length)]);
		userNameField.setForeground(new Color(200, 200, 200));
		
		getContentPane().add(passwordField);
		passwordField.setBounds(160, 110, 150, 25);
		passwordField.setText(StartupMessages.StartupMessages[new Random().nextInt(StartupMessages.StartupMessages.length)]);
		passwordField.setForeground(new Color(200, 200, 200));
		
		jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
		jLabel3.setText("LOGIN");
		jLabel3.setForeground(new Color(255, 255, 255));
		getContentPane().add(jLabel3);
		jLabel3.setBounds(150, 10, 70, 30);

		Submit = new JButton();
		Submit.setText("Login");
		getContentPane().add(Submit);
		Submit.setBounds(110, 143, 70, 20);

		
		
		Submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*if (FireBaseUtils.checkLogin()) {
					setVisible(false);
					Main.Main.window.setVisible(true);
				}*/
			}
		});
		NewAcount = new JButton();
		NewAcount.setText("New");
		getContentPane().add(NewAcount);
		NewAcount.setBounds(200, 143, 70, 20);
		
		NewAcount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					Main.Main.n.setVisible(true);
					setVisible(false);
					
				
			}
		});
		pack();
		setVisible(true);
	}
	
}

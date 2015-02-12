package FBUtils;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class LoginDialog extends JFrame  {

	public LoginDialog(){
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(550,530));
		this.setVisible(true);
		pack();
		JTextArea test =new JTextArea("test");
		//test.setAlignmentX(this.CENTER_ALIGNMENT);
		add(test,SwingConstants.CENTER);

	}
	
}

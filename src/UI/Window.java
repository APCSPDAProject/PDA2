package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import FBUtils.FireBaseUtils;
import Main.Main;


public class Window extends JFrame {

	public ChatPanel chat = new ChatPanel();
	JScrollPane scroll = new JScrollPane();
public	JScrollPane scrollChat = new JScrollPane();
	 public ChatInput CI = new ChatInput();
	PeoplePanel p = new PeoplePanel();
	
		
	public Window(){
	
		super(StartupMessages.StartupMessages[new Random().nextInt(StartupMessages.StartupMessages.length)]);
		
		CI.addKeyListener
	      (new KeyAdapter() {
	          public void keyPressed(KeyEvent e) {
	            int key = e.getKeyCode();
	            if (key == KeyEvent.VK_ENTER) {
	            	FireBaseUtils.SendMessage(Main.window.CI.getText());
					
	            }
				}
			});
		
		setLocation(new Point(Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550,530));
		
		scrollChat = new JScrollPane(chat,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollChat, BorderLayout.CENTER);
		this.add(CI, BorderLayout.SOUTH);
		
		scroll = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll, BorderLayout.WEST);
		
	
		
		pack();
		setVisible(true);
		
	}
	
	
}

package UI;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import FBUtils.FireBaseUtils;

public class ChatPanel extends JPanel{

	ChatPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
	public void UpdateChat(String newThing){
		ChatLine text = new ChatLine(newThing);
		text.setBackground(new Color(40, 40, 40));
		text.setForeground(new Color(200, 200, 200));
		
		if(newThing.startsWith(FireBaseUtils.myName)){
			//text.setAlignmentX(RIGHT_ALIGNMENT);
		//	System.out.println("me");
		}
		else{
		//	System.out.println("not me");
		//	text.setAlignmentX(LEFT_ALIGNMENT);
			text.setBackground(new Color(80, 80, 80));
		}
		
		this.add(text);
	
		this.revalidate();
	}
	
	
	
}

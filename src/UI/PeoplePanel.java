package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PeoplePanel extends JPanel{

	public static ArrayList<String> notFrom = new ArrayList<String>();
	
	public PeoplePanel(){
		
		JTextPane a = new JTextPane();
		a.setText("Chat with:");
		a.setEditable(false);
		a.setBackground(new Color(30, 30, 30));
		a.setForeground(new Color(200, 200, 200));
		a.setMaximumSize(new Dimension(200,35));
		a.setMinimumSize(new Dimension(200,35));
		this.add(a);
		UpdatePeople(new String[]{"Little Johny","Some Bitch Named DelTris","Valentina Lisitsa","Mark Mothersbaugh","Joachim Witt ","Poor Susan","Michael Jackson's Kid"});
		//notFrom.add("Little Johny");
		//notFrom.add("Poor Susan");
		TAListener.highlightUpdate();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	
	void UpdatePeople(String[] newPeople){
		
		for(String x: newPeople){			
			this.add(new TAListener(x));
			this.add(Box.createRigidArea(new Dimension(0,1)));
		}
	}
		
	void UpdatePeople(String newPerson){
		this.add(new TAListener(newPerson));
	}
	
}

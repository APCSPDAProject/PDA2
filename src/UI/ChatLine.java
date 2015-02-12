package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatLine extends JTextArea {


	public ChatLine (String name){
		this.setEditable(false);
		this.setBackground(new Color(55, 55, 55));
		this.setForeground(new Color(200, 200, 200));
		this.setMaximumSize(new Dimension(1000,35));
		this.setMinimumSize(new Dimension(50,100));
		this.setLineWrap(true);
		this.setText(name);
	}
}

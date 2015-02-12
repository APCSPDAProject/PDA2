package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

import FBUtils.FireBaseUtils;
import Main.Main;


public class TAListener extends JTextArea {

	static ArrayList<JTextArea> contactList = new ArrayList<JTextArea>(); 
	
	public TAListener(String name){
		
		this.setEditable(false);
		this.setBackground(new Color(55, 55, 55));
		this.setForeground(new Color(200, 200, 200));
		this.setMaximumSize(new Dimension(120,35));
		this.setLineWrap(true);
		
		this.setText(name);
		
		contactList.add(this);
		
		
		this.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
		
			//UpdateChat
			selectThis((JTextArea)e.getComponent());
			highlightUpdate();
			for(String x: Main.window.p.notFrom){
				
				if(((JTextArea)e.getComponent()).getText().equals(x)){
					PeoplePanel.notFrom.remove(x);
					selectThis((JTextArea)e.getComponent());
					
					highlightUpdate();
					break;
				}
			}
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}});
		
		
		
	}
	
	public void selectThis(JTextArea m){
		
		m.setBackground(new Color(200, 40, 40));
		m.setForeground(new Color(200, 200, 200));
		
		for(JTextArea x: contactList){
			if(!(x.getText().equals(m.getText()))){
				
				x.setBackground(new Color(55, 55, 55));
				x.setForeground(new Color(200, 200, 200));
				
			}else{
				FireBaseUtils.setChat(x.getText());

			}
		}
		
	}
	
	public static void highlightUpdate(){
		
		for(JTextArea x: contactList){
			for(String y: PeoplePanel.notFrom){
				if((y.equals(x.getText()))){
					x.setBackground(new Color(100, 100, 100));
					x.setForeground(new Color(200, 200, 200));
				}
			}
		}
	}
	
}

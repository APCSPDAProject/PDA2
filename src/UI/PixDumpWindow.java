package UI;


import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.smart.SmartLookAndFeel;


public class PixDumpWindow extends JFrame {

	
	public PixDumpWindow(){
		
		try {
			Properties props = new Properties();
                        
			props.put("inputBackgroundColor", "50 50 50");
			props.put("inputForegroundColor", "200 200 200");
			props.put("enabledBackgroundColor", "50 50 50");
			
            props.put("selectionBackgroundColor", "20 20 20"); 
            props.put("menuSelectionBackgroundColor", "10 10 10"); 
            
            
            props.put("windowInactiveTitleColorLight", "100 10 10"); 
            props.put("windowInactiveTitleColorDark", "0 0 0");
            props.put("windowInactiveBorderColor", "0 0 0");
            
            props.put("backgroundColor", "20 20 20");
            
            props.put("controlColor", "10 10 10");
            props.put("controlColorLight", "10 10 10");
            props.put("controlColorDark", "10 10 10"); 

            props.put("buttonForegroundColor", "200 200 200");
            props.put("buttonColor", "10 10 10");
            props.put("buttonColorLight", "10 10 10");
            props.put("buttonColorDark", "10 10 10");

            props.put("rolloverColor", "200 10 10"); 
            props.put("rolloverColorLight", "240 50 10"); 
            props.put("rolloverColorDark", "150 0 0"); 

            props.put("windowTitleForegroundColor", "200 200 200");
            props.put("windowTitleBackgroundColor", "200 200 200"); 
            props.put("windowTitleColorLight", "30 30 30"); 
            props.put("windowTitleColorDark", "0 0 0"); 
            props.put("windowBorderColor", "127 127 127");
            SmartLookAndFeel.setCurrentTheme(props);
			
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

    		
    		
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}

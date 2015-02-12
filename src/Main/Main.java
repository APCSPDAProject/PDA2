package Main;
import UI.PixDumpWindow;
import UI.Window;
import FBUtils.FireBaseUtils;

public class Main {

	public static Window window;
	static PixDumpWindow p;
	
	public static void main(String args[]){
		
		p = new PixDumpWindow();
		window = new Window();
		FireBaseUtils.init();
		FireBaseUtils.setChat("test2");
				
	}
	
}

package Main;
import FBUtils.FireBaseUtils;
import UI.LoginDialog;
import UI.NewAccountForm;
import UI.PixDumpWindow;
import UI.Window;

public class Main {

	public static Window window;
	public static LoginDialog l;
	static PixDumpWindow p;
	public static NewAccountForm n;
	
	public static void main(String args[]){
		
		p = new PixDumpWindow();
		n = new NewAccountForm();
		l = new LoginDialog();
		
		window = new Window();
		
		FireBaseUtils.init();
		FireBaseUtils.setChat("test2");
				
	}
	
}

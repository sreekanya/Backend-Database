import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class ButtonClickListener implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		
//	}
//}

public class ActionListen {
	public static void main(String[] args) {
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Action performed "+e);
				
			}
			
		};
//		listener.actionPerformed(new Button("click"));
		
	}

}

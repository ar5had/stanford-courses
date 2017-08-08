import acm.program.*;
import javax.swing.*;
import java.awt.event.*;
public class Greet extends ConsoleProgram{

	public void run(){
		
		
		name=new JTextField(10); 
		
		add(new JLabel("Name:"),SOUTH);
		add(name,SOUTH);
		
		name.addActionListener(this);
			
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==name){
			
			println("Hello,"+name.getText());
		}
		
		
	}
	
	
	private JTextField name;
	
}

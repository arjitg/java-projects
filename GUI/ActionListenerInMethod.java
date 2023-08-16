package GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionListenerInMethod  extends JFrame {
	
	ActionListenerInMethod (){
		initComponent();
	}
	
 public void initComponent() {
	 JButton jbtOK = new JButton("OK");
	 add(jbtOK);
	 
	 jbtOK.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 printMe();
		 }// end method

		private void printMe() {
			System.out.println("The OK button is clicked");
			
		}
	    }// end 
	 
     ); //end of method

 }

 public static void main(String[] args) {
	 JFrame frame = new ActionListenerInMethod();
	 frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);
   } 
 }

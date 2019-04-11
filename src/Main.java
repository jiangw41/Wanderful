import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Font;
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void userInput(){
		//Scanner in = new Scanner(System.in);
		//System.out.print("Enter number of steps: ");
		//int input_steps = in.nextInt();
	}
	
	public static List<String> streets() {
		try {
			List<String> streets_name = new ArrayList<String>();
			Scanner streetNames = new Scanner(new File("src/Streets.csv"));
				while (streetNames.hasNextLine()){
					String current = streetNames.nextLine();
					if (!(current.contentEquals("﻿FULL_STREET_NAME"))) {
						streets_name.add(current);
					}
					//System.out.println(current);
				}
				streetNames.close();
				return streets_name;
			}

		catch(FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return null;
	}

	public static void JFrame(){
		final Font font,font2,font3;
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
	    frame.setLocation(430, 100);
	    
	    JPanel panel = new JPanel();
	    frame.add(panel);

	    JLabel lbl = new JLabel("Choose your street");
	    List<String> choices = streets();
	    
	    JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));
	    JComboBox<String> cb2 = new JComboBox<String>(choices.toArray(new String[0]));
	    
	    JTextField StreetNum = new JTextField(10);
	    
	    JButton btn = new JButton("OK");
	    
	    lbl.setVisible(true);
	    cb.setVisible(true);
	    cb2.setVisible(true);
	    btn.setVisible(true);
	    
	    panel.add(lbl);
	    panel.add(cb);	    
	    panel.add(cb2);	    
	    //panel.add(btn);
	    panel.add(StreetNum);

        font = new Font("TimesRoman", Font.BOLD, 30);
        font2 = new Font("Verdana", Font.PLAIN, 20);
        font3 = new Font("Verdana", Font.PLAIN, 20);
	    lbl.setFont(font);
	    cb.setFont(font2);
	    cb2.setFont(font2);
	    btn.setFont(font3);
	    StreetNum.setFont(font3);
	}

	public static void main(String[] args) {			
		JFrame();
		userInput();
	}
}
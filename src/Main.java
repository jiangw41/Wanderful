import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;


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
		final Font font,font2;
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 300);
	    frame.setLocation(430, 100);

	    
	    JPanel panel = new JPanel();
	    frame.add(panel);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel lbl = new JLabel("Choose your street", SwingConstants.CENTER);
	    JLabel lbl2 = new JLabel("Choose your street Number.", SwingConstants.CENTER);
	    
	    List<String> choices = streets();
	    JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));
	    JTextField StreetNum = new JTextField(10);
	    JButton btn = new JButton("OK");
	    
	    panel.add(lbl);
	    panel.add(cb);	        
	    //panel.add(btn);
	    panel.add(lbl2);
	    panel.add(StreetNum);

        font = new Font("TimesRoman", Font.BOLD, 30);
        font2 = new Font("Verdana", Font.PLAIN, 20);
	    lbl.setFont(font);
	    cb.setFont(font2);
	    btn.setFont(font2);
	    lbl2.setFont(font);
	    StreetNum.setFont(font3);
	}

	public static void main(String[] args) {			
		JFrame();
		userInput();
	}
}
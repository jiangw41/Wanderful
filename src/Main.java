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
		final Font TitleFont,TextFont;
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 330);
	    frame.setLocation(430, 100);

	    
	    JPanel panel = new JPanel();
	    frame.add(panel);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel lbl = new JLabel("Choose your street", SwingConstants.CENTER);
	    JLabel lbl2 = new JLabel("Choose your street Number", SwingConstants.CENTER);
	    JLabel lbl3 = new JLabel("Enter Step Goal", SwingConstants.CENTER);
	    JLabel lbl4 = new JLabel("Step walked today", SwingConstants.CENTER);
	    
	    List<String> choices = streets();
	    JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));
	    JTextField StreetNum = new JTextField(10);
	    JTextField StepGoal = new JTextField(10);
	    JTextField StepWalked = new JTextField(10);
	    JButton btn = new JButton("OK");
	    
	    panel.add(lbl);
	    panel.add(cb);	        
	    //panel.add(btn);
	    panel.add(lbl2);
	    panel.add(StreetNum);
	    panel.add(lbl3);
	    panel.add(StepGoal);
	    panel.add(lbl4);
	    panel.add(StepWalked);

	    TitleFont = new Font("TimesRoman", Font.BOLD, 30);
	    TextFont = new Font("Verdana", Font.PLAIN, 20);
	    lbl.setFont(TitleFont);
	    lbl2.setFont(TitleFont);
	    lbl3.setFont(TitleFont);
	    lbl4.setFont(TitleFont);
	    cb.setFont(TextFont);
	    btn.setFont(TextFont);
	    StreetNum.setFont(TextFont);
	    StepGoal.setFont(TextFont);
	    StepWalked.setFont(TextFont);
	}

	public static void main(String[] args) {			
		JFrame();
		userInput();
	}
}
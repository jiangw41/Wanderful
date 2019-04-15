import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;


public class Main {
	
	public static List<String> streets() {
		try {
			List<String> streets_name = new ArrayList<String>();
			Scanner streetNames = new Scanner(new File("src/Streets.csv"));
			String current = streetNames.nextLine();
				while (streetNames.hasNextLine()){
					current = streetNames.nextLine();
					streets_name.add(current);
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

	public static void JFrame(String Choice1, String Choice2){

		final Font TitleFont,TextFont;
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
	    frame.setLocation(0, 0);

	    
	    JPanel panel = new JPanel();
	    frame.add(panel);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel lbl = new JLabel("Choose Your Street", SwingConstants.CENTER);
	    JLabel lbl2 = new JLabel("Choose Your Street Number", SwingConstants.CENTER);
	    JLabel lbl3 = new JLabel("Enter Distance Goal(m)", SwingConstants.CENTER);
	    JLabel lbl4 = new JLabel("Distance Walked Today(m)", SwingConstants.CENTER);
	    
	    //NumberFormat amountFormat = NumberFormat.getNumberInstance();	    
	    //JFormattedTextField amountField = new JFormattedTextField(amountFormat);
	    
	    List<String> choices = streets();
	    JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));
	    JTextField StreetNum = new JTextField(10);
	    JTextField StepGoal = new JTextField(10);
	    JTextField StepWalked = new JTextField(10);
	    JButton btn = new JButton("NEXT");
	    
	    
	    btn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String StreetNameValue = (String)cb.getSelectedItem();
	    		String StreetNumValue = StreetNum.getText();
	    		String StepGoalValue = StepGoal.getText();
	    		String StepWalkedValue = StepWalked.getText();
	    		/*
	    		System.out.println(StreetNameValue);
	    		System.out.println(StreetNumValue);
	    		System.out.println(StepGoalValue);
	    		System.out.println(StepWalkedValue);
	    		*/
	    		//close current frame, open new one
	    		frame.setVisible(false);
	    		SecondFrame(Choice1,Choice2);
	    	}
	    });
	   
	    panel.add(lbl2);
	    panel.add(StreetNum);	    
	    panel.add(lbl);
	    panel.add(cb);	        
	    panel.add(lbl3);
	    panel.add(StepGoal);
	    panel.add(lbl4);
	    panel.add(StepWalked);
	    panel.add(btn);
	    //panel.add(amountField);
	    
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
	 
	public static void SecondFrame(String c1, String c2) {
		JFrame frame1 = new JFrame("Wanderful Application");
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(700, 400);
	    frame1.setLocation(0, 0);
	    
	    JPanel panel = new JPanel();
	    frame1.add(panel);
	    JTextArea  C1 = new JTextArea ();
	    JLabel C2 = new JLabel();
	    JLabel C3 = new JLabel("                                                     ");
		C1.setText(String.valueOf(c1));
	    C1.setWrapStyleWord(true);
		C2.setText(String.valueOf(c2));
	    panel.add(C1);	     
	    panel.add(C3);   
	    panel.add(C2);
	    
		final Font TextFont;
	    TextFont = new Font("Verdana", Font.PLAIN, 20);
	    C1.setFont(TextFont);
	    C2.setFont(TextFont);
	    C3.setFont(TextFont);
	    
	}

	public static void main(String[] args) {			
	    
	    Intersection x = Reader.currentLocation("299", "Southbrook Drive");
	    Intersection[] y = Reader.Hamilton();
		//System.out.println(y[10].distTo(x));

		QuickSort.sort(y, "lat");
		System.out.println(x);
		Paths paths = new Paths(x, y, 2000);
		String Choice1 = paths.getChoices().toString();
		String Choice2 = paths.getChoices2().toString();
		System.out.println(Choice1);
		System.out.println(Choice2);	//Shows list of all the points
		
		JFrame(Choice1,Choice2);
	    System.out.println();
	    
		//System.out.println(paths.getSize());
	    //System.out.println(x.distTo(y[20]));
	}
}

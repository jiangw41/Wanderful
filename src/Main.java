<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
package project.wt;

>>>>>>> 770d515c504828d5640065c7e15e3d6a202e8571
>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;



public class Main {

	public static void userInput(){
		//Scanner in = new Scanner(System.in);
		//System.out.print("Enter number of steps: ");
		//int input_steps = in.nextInt();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
	}
	
	public static List<String> streets() {
		try {
			List<String> streets_name = new ArrayList<String>();
			Scanner streetNames = new Scanner(new File("src/Streets.csv"));
				while (streetNames.hasNextLine()){
					String current = streetNames.nextLine();
					streets_name.add(current);
					//System.out.println(current);
				}
				return streets_name;
			}

		catch(FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return null;
	}

	public static void JFrame(){
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
	    frame.setLocation(430, 100);
	    
	    JPanel panel = new JPanel();

	    frame.add(panel);

	    JLabel lbl = new JLabel("Choose your street");
	    lbl.setVisible(true);
	    
	    panel.add(lbl);

	    List<String> choices = streets();
	    
	    /*
	    for (int i = 1; i < choices.size(); i++) {
			System.out.println(choices.get(i));
		}
	    */
	    final JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));
<<<<<<< HEAD
=======

>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
	    cb.setVisible(true);
	    panel.add(cb);

	    final JComboBox<String> d = new JComboBox<String>(choices.toArray(new String[0]));
<<<<<<< HEAD
=======

>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
	    cb.setVisible(true);
	    panel.add(d);

	    JButton btn = new JButton("OK");
	    panel.add(btn);
<<<<<<< HEAD
=======
=======
>>>>>>> 770d515c504828d5640065c7e15e3d6a202e8571
>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
	}
	
	public static List<String> streets() {
		try {
			List<String> streets_name = new ArrayList<String>();
			Scanner streetNames = new Scanner(new File("Streets.csv"));
					while (streetNames.hasNextLine()){
						String current = streetNames.nextLine();
						streets_name.add(current);
						//System.out.println(current);
					}
					return streets_name;
			}

		catch(FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
<<<<<<< HEAD
		//Intersection[] x = Reader.Hamilton();
		//System.out.println(x[1]);
		
		// Run QuickSort to print sorted elements
		
=======
<<<<<<< HEAD
=======
		//Intersection[] x = Reader.Hamilton();
		//System.out.println(x[1]);
		
		JFrame frame = new JFrame("Wanderful Application");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
	    frame.setLocation(430, 100);
	    
	    JPanel panel = new JPanel();

	    frame.add(panel);

	    JLabel lbl = new JLabel("Choose your street");
	    lbl.setVisible(true);
	    
	    panel.add(lbl);

	    List<String> choices = streets();
	    
	    for (int i = 1; i < choices.size(); i++) {
			System.out.println(choices.get(i));
		}
	    
	    final JComboBox<String> cb = new JComboBox<String>(choices.toArray(new String[0]));

	    cb.setVisible(true);
	    panel.add(cb);

	    JButton btn = new JButton("OK");
	    panel.add(btn);

	    
		
>>>>>>> 770d515c504828d5640065c7e15e3d6a202e8571
		
		//Intersection[] x = Reader.Hamilton();
		//System.out.println(x[1]);
		
		// Run QuickSort to print sorted elements
		
>>>>>>> 5cd13ee8dfdcb9abe535a2f3194b171fed4d5c79
		JFrame();
		userInput();

	}

}
package hack17_active;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.leapmotion.leap.Frame;

public class ui extends Frame implements WindowListener,ActionListener
{
	//init global vars
	JFrame frame;
	Panel home;
	Panel about;
	Panel settings;
	Panel exercise;
	Panel exercise2;
	GridLayout experimentLayout = new GridLayout(7,0);
	
	public ui()
	{
		//declare frame with size
		frame = new JFrame();
		
		frame.setSize(600, 200);
		
		//launch initial page
		homePage();
	}
	
	public static void main(String[] args) {
		new ui();
	}
	
	//set of button names with associated methods
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String toDo = arg0.getActionCommand();
		
		if(toDo.equalsIgnoreCase("start"))
		{
			//run the program
			startPage();
		}
		else if(toDo.equalsIgnoreCase("settings"))
		{
			//open settings page
			settingsPage();
		}
		else if(toDo.equalsIgnoreCase("about"))
		{
			//open about page
			aboutPage();
		}
		else if(toDo.equalsIgnoreCase("exit"))
		{
			//exit the application
			exitPage();
		}
		else if(toDo.equalsIgnoreCase("back"))
		{
			//return to home menu
			aboutBack();
		}
		else if(toDo.equalsIgnoreCase("save and go back"))
		{
			//return to home menu
			settingsBack();
		}
		else if(toDo.equalsIgnoreCase("continue"))
		{
			//closes panel if they exercised
			yes();
		}
		else if(toDo.equalsIgnoreCase("dismiss"))
		{
			//ignores alert and closes panel
/*****/			
		}
		else if(toDo.equalsIgnoreCase("snooze"))
		{
			//resets count to 2700 and closes panel
/*****/			
		}
		else if(toDo.equalsIgnoreCase("home"))
		{
			//return to home menu
			homeBack();
		}
		else if(toDo.equalsIgnoreCase("home?"))
		{
			//return to home menu
			homeBack2();
		}
		else if(toDo.equalsIgnoreCase("continue?"))
		{
			//closes panel if they exercised
			yes2();
		}
		else if(toDo.equalsIgnoreCase("dismiss?"))
		{
			//ignores alert and closes panel
/*****/			
		}
/*		else if(toDo.equalsIgnoreCase("snooze?"))
		{
			//resets count to 2700 and closes panel	
		}
*/		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void homePage()
	{
		home = new Panel();          				// set the page
		
		Button start = new Button("Start"); 		// set buttons on the page
		Button settings = new Button("Settings");
		Button about = new Button("About");
		Button exit = new Button("Exit");
		
		start.addActionListener(this);				// collect button presses
		settings.addActionListener(this);
		about.addActionListener(this);
		exit.addActionListener(this);		
		
		home.add(start);                    		 // add buttons to panel
		home.add(settings);
		home.add(about);
		home.add(exit);
		
		frame.add(home);							//display panel
		frame.setVisible(true);	
	}
	
	public void startPage()
	{
		frame.setVisible(false);
		frame.remove(home);							//hide home page
		
		String[] args = null;
		motion.main(args);							//run the program
	}
	
	public void settingsPage()
	{
		settings = new Panel();
		
		Button back = new Button("Save and go back");
		
		back.addActionListener(this);
		
		/*
			allow user to modify settings to customize their activity experiences
		*/
		
		settings.add(back);		
		
		frame.setVisible(false);
		frame.remove(home);
		
		Label settingsText = new Label("");
		settings.add(settingsText);
		
		frame.add(settings);
		frame.setVisible(true);
		
		
	}
	
	public void aboutPage()
	{
		about =  new Panel();
		
        about.setLayout(experimentLayout);
		
		Button back = new Button("Back");
		
		back.addActionListener(this);
		
		frame.setVisible(false);
		frame.remove(home);
		
		frame.setLayout(new GridBagLayout());
		
		String labelText = "Leap Up is a program designed to promote an active workplace.";/*\nIt uses a LEAP Motion infrared camera to detect the position of a"
				+ " user sitting at a desk,\nand prompts them to exercise after a set amount of time.\nIt then ensures that they have left their desk for a set amount"
				+ " of time before removing the text alert.\n";*/
		
		Label aboutText = new Label(labelText);
		about.add(aboutText);
		
		labelText = "It uses a LEAP Motion infrared camera to detect the position of a user sitting at a desk,";
		
		aboutText = new Label(labelText);
		about.add(aboutText);
		
		labelText = "and prompts them to exercise after a set amount of time.";
		
		aboutText = new Label(labelText);
		about.add(aboutText);
		
		labelText = "It then ensures that they have left their desk for a set amount of time before removing the text alert.";
		
		aboutText = new Label(labelText);
		about.add(aboutText);
		
		about.add(back);
		
	    frame.add(about, new GridBagConstraints());
		
		frame.add(about);
		frame.setVisible(true);
		
		System.out.println("this is the about page thanks");
	}
	
	public void exitPage()
	{
		frame.setVisible(false);
		frame.remove(home);
	}
	
	public void aboutBack()
	{
		frame.setVisible(false);
		frame.remove(about);
		
		frame.add(home);
		frame.setVisible(true);
		
		System.out.println("this takes you home pls");
	}
	
	public void settingsBack()
	{
		frame.setVisible(false);
		frame.remove(settings);
		
		frame.add(home);
		frame.setVisible(true);
		
		System.out.println("this takes you home pls");
	}
	
	public void homeBack()
	{
		frame.setVisible(false);
		frame.remove(exercise);
		
		frame.add(home);
		frame.setVisible(true);
	}
	
	public void homeBack2()
	{
		frame.setVisible(false);
		frame.remove(exercise2);
		
		frame.add(home);
		frame.setVisible(true);
	}
	
	public void exerciseAlert()
	{
		exercise = new Panel();          			// Panel is a container
		
		Button yes = new Button("Continue"); 		// Button is a component
		Button dismiss = new Button("Dismiss");
		Button snooze = new Button("Snooze");
		Button home = new Button("Home");
		
		yes.addActionListener(this);
		dismiss.addActionListener(this);
		snooze.addActionListener(this);	
		home.addActionListener(this);
		
		exercise.add(yes);                    		 // The Panel container adds a Button component
		exercise.add(dismiss);
		exercise.add(snooze);
		exercise.add(home);
		
		frame.add(exercise);
		frame.setVisible(true);
	}
	
	public void exerciseAgain()
	{
		exercise2 = new Panel();          			// Panel is a container
		
		Button yes = new Button("Continue?"); 		// Button is a component
		Button dismiss = new Button("Dismiss?");
		//Button snooze = new Button("Snooze?");
		Button home = new Button("Home?");
		
		yes.addActionListener(this);
		dismiss.addActionListener(this);
		//snooze.addActionListener(this);	
		home.addActionListener(this);
		
		exercise2.add(yes);                    		 // The Panel container adds a Button component
		exercise2.add(dismiss);
		//exercise2.add(snooze);
		exercise2.add(home);
		
		frame.setVisible(false);
		frame.remove(exercise);
		
		frame.add(exercise2);
		frame.setVisible(true);
	}
	
	public void yes()
	{
		frame.setVisible(false);
		frame.remove(exercise);
	}
	
	public String dismiss()
	{
		//break out of the counter loop
		//close panel
		
		String no = "dismiss";
		return no;
	}
	
	public String snooze()
	{
		//set count to 2700
		//exit if statement?
		//close panel
		
		String snooze = "snooze";
		return snooze;
	}
	
	public void yes2()
	{
		frame.setVisible(false);
		frame.remove(exercise2);
	}

}

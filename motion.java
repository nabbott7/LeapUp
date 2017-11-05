package hack17_active;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.HandList;

public class motion {

	public static void main(String[] args) {
		
		//declare vars, controller, listener
		int count = 0;											
		int count2 = 0;
		boolean breaker = true;
		boolean breaker2 = true;
		
		//ui visuals = new ui();
		
		Controller con = new Controller();		
		
		//while not broken out of loop
		while(breaker) 
		{
			//look for hands in every frame
			Frame frame = con.frame();
			HandList handsInFrame = frame.hands();
			
			//while there are hands in frame
			while(handsInFrame.count() > 0)
			{
				try 
				{
					//make sure that the user has not been in frame for an hour
					TimeUnit.SECONDS.sleep(1);
					
					//if they havent moved in an hour
					if(count >= 10)
					{
						
						//force them to get out of their chair
						final JPanel panel = new JPanel();
/******/				JOptionPane.showMessageDialog(panel, "Time to exercise for at least a minute! Wait until you're back to clear this message.", "Exercise Alert", JOptionPane.ERROR_MESSAGE);

/*
						//visuals.exerciseAlert();
						
					
						if(dismiss)
							break;
						if(!snooze)
							v
*/			
						//for at least a minute
						while(count2 <= 5)
						{	
							frame = con.frame();
							handsInFrame = frame.hands();
							
							//if they come back within a minute of exercise
							if(handsInFrame.count() > 0)
							{
/*******/						JOptionPane.showMessageDialog(panel, "You didn't exercise for a minute! Wait until you're back to clear this message", "Exercise Alert", JOptionPane.ERROR_MESSAGE);

								breaker2 = false;
								break;
							}
							TimeUnit.SECONDS.sleep(1);
							count2++;
							
							breaker2 = true;
						}
						
						//reset program
						if(breaker2 == true)
						{
							breaker = false;
							break;
						}
					}	
						
					System.out.println(count);
					
					//increment second timer
					count++;
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
				//recheck for hands on keyboard
				frame = con.frame();
				handsInFrame = frame.hands();
			}
			
			//if the person was at the keyboard then left without being told to
			if(count >= 1)
			{
				//wait 60 seconds to ensure they exercised
				while(count2 <= 60)
				{						
					try 
					{
						//if they come back in 60 seconds, it doesnt count
						if(handsInFrame.count() > 0)
						{							
							breaker2 = false;
							break;
						}
						
						TimeUnit.SECONDS.sleep(1);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					count2++;
					
					breaker2 = true;
				}
				
				if(breaker2 == true)
					breaker = false;
			}
			
			System.out.println("you are exercising");
		}
		
		System.out.println("Press Enter to quit...");
		
		try
		{
			System.in.read();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

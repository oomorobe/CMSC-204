import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws a car shape and moves it based on directions from CarQueue.
   @author (edited/modified) Okeoghene Excel Omorobe 
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x, y, delay;
	private CarQueue carQueue;
	private int direction;
	
	public CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
		x = x1;
		y = y1;
		car1 = new Car(x, y, this);
		carQueue = queue;
	}
	
	public void startAnimation()
	{
		class AnimationRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					for (int i = 0; i < 50; i++) // You can increase this for longer animation
					{
						direction = carQueue.deleteQueue();

						// Move based on direction
						switch (direction)
						{
							case 0: y -= 10; break; // up
							case 1: y += 10; break; // down
							case 2: x += 10; break; // right
							case 3: x -= 10; break; // left
						}

						// Boundary check with reversal logic
						if (x < 0) {
							x = 0;
							direction = 2; // reverse to right
						}
						if (x > getWidth() - 60) {
							x = getWidth() - 60;
							direction = 3; // reverse to left
						}
						if (y < 0) {
							y = 0;
							direction = 1; // reverse to down
						}
						if (y > getHeight() - 30) {
							y = getHeight() - 30;
							direction = 0; // reverse to up
						}

						repaint();
						Thread.sleep(delay * 1000);
					}
				}
				catch (InterruptedException exception)
				{
					// Handle exception
				}
			}
		}
		
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;
		car1.draw(g2, x, y);    
	}
}

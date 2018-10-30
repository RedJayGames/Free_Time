import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class Snowman extends Applet{

	public void paint(Graphics page){
		final int MID = 150;
		final int TOP = 50;
		
		setBackground (Color.cyan);
		
		//ground
		page.setColor(Color.blue);
		page.fillRect(0,  175,  300,  50);
		
		//sun
		page.setColor(Color.yellow);
		page.fillOval(-40, -40, 80, 80);
		
		//body
		page.setColor(Color.white);
		//head
		page.fillOval(MID - 20, TOP, 40, 40);
		//mid
		page.fillOval(MID - 35, TOP + 30, 70, 50);
		//base
		page.fillOval(MID - 50, TOP + 80, 100, 60);
		
		//eyes
		page.setColor(Color.black);
		//left
		page.fillOval(MID - 10,  TOP + 10, 5, 5);
		//right
		page.fillOval(MID + 5, TOP + 10, 5, 5);
		
		//mouth
		page.drawArc(MID - 10,TOP + 20, 20, 10, 190, 160);
		
		//arms
		//left
		page.drawLine(MID - 25,TOP + 60, MID - 50, TOP + 40);
		//right
		page.drawLine(MID + 25, TOP + 60,MID + 55,TOP + 60);
		
		//hat
		//base
		page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
		//top
		page.fillRect(MID - 15,TOP - 20, 30, 25);
		
		//nose
		int xpoints[] = {MID - 2, MID - 2, MID + 10};
		int ypoints[] = {TOP + 17, TOP + 21, TOP + 19};
		int npoints = 3;
		
		page.setColor(Color.orange);
		page.fillPolygon(xpoints, ypoints, npoints);
		
		System.out.println("Done!");
	}
	
}

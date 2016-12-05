package onMyOwnSquare;

import java.awt.*;
import java.util.*;


public class Square 
{
	int height;
	int width;
	int baseHeight;
	
	Color c;
	
	int x;
	int y;
	
	double dx = Math.random() * 10 - 5;	
	double dy = Math.random() * 10 - 5; 
	
	public Square (int height, int width, Color c, int x, int y)
	{
		this.height = height;
		this.width = width;
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	public Square (int hight, int width, Dimension d)
	{
		Random rnd = new Random();
		
		this.height = height + rnd.nextInt(31);
		this.width = this.height;
		baseHeight = height;
		
		c = Color.red;
		
		x = height + (int)(Math.random() * (d.width - 2*width));		
		y = width + (int)(Math.random() * (d.height - 2*height));		
	}
	
	public void colorChanger(Color c2)		
	{
		this.c = c2;
	}
	
	public void multiColor()			
	{
		this.c = new Color(				
				(float) Math.random(), 
				(float) Math.random(), 
				(float) Math.random());
		
	}
	
	public void makeMeSmall()
	{
		if (++ baseHeight >= height)
			baseHeight = 0;
	} 
	
	public void drawMe (Graphics g)
	{
		g.setColor(c);
		g.fillRect(x, y+baseHeight/2, width, height-baseHeight);
	}
	
	public void moveMe(Dimension d) 	
	{
		x += dx;						
		y += dy;
		if( x > d.width) x = 0;
		else if(x < 0) x = d.width;
		if( y > d.height) y = 0;
		else if(y < 0) y = d.height;
	}
	
}
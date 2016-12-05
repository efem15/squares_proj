/*
 *  Java applet which is animating squares. While squares are moving, their height is reduced to 0 
 * and after that restore to normal height. Default color of each square is red, but after clicking 
 * the button, color is changing: left button change squares to black, right to white 
 * and the middle paint them in random colors.
 */

package onMyOwnSquare;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class OneSquare extends Applet implements Runnable, MouseListener
{
	private static final long serialVersionUID = 1L; 
	
	ArrayList<Square> squares;
	
	
	@Override
	public void init() 
	{
		setBackground(Color.gray);
		
		Dimension appletSpace = getSize();			
		
		int N = 10; 
		squares = new ArrayList<Square>(N);	
		for (int i = 0; i < N; i++)
			squares.add(new Square(30, 30, appletSpace));
		
		new Thread(this).start();
		
		addMouseListener(this);	
	}
	
	public void hightChanger()
	{
		for(Square s : squares)
			s.makeMeSmall();
	}

	@Override
	public void paint(Graphics g) 		
	{
		for(Square s : squares)
			s.drawMe(g);
	}

	
	@Override
	public void run() 
	{
		while(true)	
		{
			try 
			{
				Thread.sleep(200);
			} catch (InterruptedException e) 
			  {
				e.printStackTrace();	
			  }
			
			Dimension appletSpace = getSize();	
			for(Square s : squares)		
				s.moveMe(appletSpace);			
			
			hightChanger();		
			
			this.repaint();				
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
			for(Square sq : squares)
				sq.colorChanger(Color.BLACK);
		else if (e.getButton() == MouseEvent.BUTTON2)
			for(Square sq : squares)
				sq.multiColor();
		else if (e.getButton() == MouseEvent.BUTTON3)
			for(Square sq : squares)
				sq.colorChanger(Color.WHITE);
		
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		System.out.println(e);	
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		System.out.println(e);	
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		System.out.println(e);
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		System.out.println(e);	
	}		
}


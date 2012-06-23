package artlife;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D; 

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class ArtLifeMain extends JApplet
{
    
	private static final long serialVersionUID = 1L;
	Grid grid;
	DrawPanel draw;
    
    public void init(){
        //Execute a job on the event-dispatching thread:
    	//creating this applet's GUI.
    	try {
        	javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            	public void run() {
             		grid = Grid.getGrid();
             		setSize(128*6, 128*6);
                	createGUI();
            	}
        	});
        	System.out.println("We are done running.");
        	DrawThread drawing = new DrawThread();
        	drawing.start();
        	ActionThread action = new ActionThread();
        	action.start();
    	} catch (Exception e) {
        	System.err.println("createGUI didn't successfully complete");
    	}
    }
    
    public void createGUI(){
        draw = new DrawPanel();
    	getContentPane().add(draw, BorderLayout.CENTER);

    }
    
    /**
     * This is the main entry point for the application
     */
    public static void main(String args[]) 
    {
    	ArtLifeMain main = new ArtLifeMain();
        main.init();
    }
    
    class DrawThread extends Thread{
    	public void run() {
    		while(true) {
    			draw.repaint();
    			try {
    				sleep(5);
    			}catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    }
    
    class ActionThread extends Thread{
    	public void run() {
    		int round = 0;
    		while(true) {
    			grid.update();
    			round++;
    			System.out.println(round);
    			try {
    				sleep(5);
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    class DrawPanel extends JPanel{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics graphics){
            super.paintComponent(graphics);
            Graphics2D g = (Graphics2D) graphics;
            setBackground(Color.black);
            grid.draw(g);
            repaint();
        }
    }
    
}

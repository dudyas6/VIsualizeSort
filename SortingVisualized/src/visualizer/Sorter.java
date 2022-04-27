package visualizer;


import static visualizer.Sleeper.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Sorter extends JPanel {
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
    private static final int BAR_WIDTH = 8;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
    
    private int[] array;
    private int[] colors;
 
    
    public Sorter() {
        setBackground(Color.darkGray);
        array = new int[NUM_BARS]; colors = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i+20;
            colors[i] = 0;
        }
    }
    
    public void randomize() {
        Random rng = new Random();
        for (int i = 0; i < array.length; i++) { 
        	int indx = rng.nextInt(NUM_BARS-1);
        	swap(i,indx, 5);
        }
        
    }
   
    public int getLen() {
    	return array.length;
    }
    
    public int getItem(int indx) {
    	return array[indx];
    }
    
    public void swap(int i, int j, int delay) 
    {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    	
    	colors[i] = 100;
    	colors[j] = 100;
    	
    	repaint();
    	sleep(millisecondsToNano(delay));
    }
    
    //graphical coding below :
    
    public void updateRect(int value, int index, long millisecondDelay) {
    	array[index] = value;
        colors[index] = 100;
        repaint();
        sleep(millisecondsToNano(millisecondDelay));
    }
    
    public void flashArr() {
        for (int i = 0; i < getLen(); i++) {
            updateRect(getItem(i) , i , 5);
        }
    }
    
    
    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            colors[i] = 0;
        }
        repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) 
    {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        
        for (int x = 0; x < NUM_BARS; x++) 
        {
            int height = array[x] * 3;
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = WIN_HEIGHT - height;
            int val = colors[x] * 2;
            graphics.setColor(new Color(255, 255 - val, 255 - val));
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
            if (colors[x] > 0) 
            {
                colors[x] -= 10;
            }
        }
        
    }
    
    
}

package visualizer;

import static visualizer.Sleeper.*;

import java.util.ArrayList;
import javax.swing.*;
import visualizer.algorithms.*;


public class Visualizer {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private JFrame screen;
	private Sorter curSort;
	private ArrayList<SortingInterface> queue;
	
	public Visualizer() {
		screen = new JFrame("Visualizer");
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setSize(WIDTH, HEIGHT);
		curSort = new Sorter();
		screen.add(curSort);
		screen.setVisible(true);
		
		queue = new ArrayList<>();
		queue.add(new MergeSort());
	}
	
	public void shuffleHold() {
		curSort.randomize();
		curSort.resetColours();
		sleep(secondsToNano(1));
	}
	
	public void run() {
		for(SortingInterface alg : queue) {
			shuffleHold();
			alg.runSort(curSort);
			System.err.println("Finished Sorting with : " + alg.getClass().getSimpleName());
			curSort.resetColours();
			curSort.flashArr();
			curSort.resetColours();
			sleep(secondsToNano(2));
		}
	}
	

    
}

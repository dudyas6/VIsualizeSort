package visualizer.algorithms;

import visualizer.Sorter;

public class BubbleSort implements SortingInterface {

	@Override
	public void runSort(Sorter arr) {
        int n = arr.getLen();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.getItem(j) > arr.getItem(j+1)) {
                	arr.swap(j, j+1, 5);
                }
                	
	}

}

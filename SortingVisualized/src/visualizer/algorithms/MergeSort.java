package visualizer.algorithms;

import visualizer.Sorter;

public class MergeSort implements SortingInterface  {

	@Override
	public void runSort(Sorter arr) {
		int l = 0, r = arr.getLen() - 1;
		mergeSort(arr, l, r);
	}

	private void mergeSort(Sorter arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr,l,m,r);
		}
		
	}

	private void merge(Sorter arr, int l, int m, int r) {
		int t1 = m - l + 1;
		int t2 = r - m;
		
		int L[] = new int[t1];
		int R[] = new int[t2];
		
		for (int i = 0; i < t1; i++) {
			L[i] = arr.getItem(l+i);
		}
		for (int j = 0; j < t2; j++) {
			R[j] = arr.getItem(m + 1 + j);
		}
		
		int i = 0, j = 0;
		int k = l;
		while(i<t1 && j<t2) {
			if(L[i] <= R[j]) {
				arr.updateRect(L[i], k, 10);
				i++;
			}
			else {
				arr.updateRect(R[j], k, 10);
				j++;
			}
			k++;
		}
		while (i< t1) {
			arr.updateRect(L[i], k, 10);
			i++;
			k++;
		}
		while (j< t2) {
			arr.updateRect(R[j], k, 10);
			j++;
			k++;
		}
	}
	
}

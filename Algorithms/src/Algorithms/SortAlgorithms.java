package Algorithms;

public class SortAlgorithms {
	private int [] nums;
	private static final int maxNum = 1000;
	private static final int sortArraySize = 1000;
	private static final int sortArrayGroupSize = 1000;
	
	SortAlgorithms() {
		nums = new int [sortArraySize];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * maxNum); //generate random numbers from 0 to maxNum.
		}
	}
	
	public void sortAlgorithmTest() {
		selectionSortTest();
		insertionSortTest();
		shellSortTest();
		mergeSortTest();
		quickSortTest();
	}
	
	private void selectionSortTest() {
		long selectionSortTime = 0;
		
		SortAlgorithms [] sort = new SortAlgorithms [sortArrayGroupSize];
		
		for(int i = 0; i < sortArrayGroupSize; i++){
			sort[i] = new SortAlgorithms();
		}
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < sortArrayGroupSize; i++) {
			sort[i].selectionSort(nums, 0, nums.length);
		}

		long endTime = System.currentTimeMillis();
		
		selectionSortTime = endTime - startTime;
		
		System.out.println("Selection sort time" + "(" + sortArrayGroupSize + "*" + sortArraySize + ")" + ":"  + (double)selectionSortTime / 1000 + "s");
	}
	
	private void insertionSortTest() {
		SortAlgorithms [] sort = new SortAlgorithms [sortArrayGroupSize];
		
		long insertionSortTime = 0;
		
		for(int i = 0; i < sortArrayGroupSize; i++){
			sort[i] = new SortAlgorithms();
		}
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < sortArrayGroupSize; i++) {
			sort[i].insertionSort(nums, 0, nums.length);
		}

		long endTime = System.currentTimeMillis();
		
		insertionSortTime = endTime - startTime;
		
		System.out.println("Insertion sort time" + "(" + sortArrayGroupSize + "*" + sortArraySize + ")" + ":"  + (double)insertionSortTime / 1000 + "s");
	}
	
	private void shellSortTest() {
		SortAlgorithms [] sort = new SortAlgorithms [sortArrayGroupSize];
		
		long shellSortTime = 0;
		
		for(int i = 0; i < sortArrayGroupSize; i++){
			sort[i] = new SortAlgorithms();
		}
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < sortArrayGroupSize; i++) {
			sort[i].shellSort(nums, 0, nums.length);
			//sort[i].isSorted();
		}

		long endTime = System.currentTimeMillis();
		
		shellSortTime = endTime - startTime;
		
		System.out.println("Shell sort time" + "(" + sortArrayGroupSize + "*" + sortArraySize + ")" + ":"  + (double)shellSortTime / 1000 + "s");
	}
	
	private void mergeSortTest() {
		SortAlgorithms [] sort = new SortAlgorithms [sortArrayGroupSize];
		
		long mergeSortTime = 0;
		
		for(int i = 0; i < sortArrayGroupSize; i++){
			sort[i] = new SortAlgorithms();
		}
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < sortArrayGroupSize; i++) {
			sort[i].mergeSort(nums, 0, nums.length);
			//sort[i].isSorted();
		}

		long endTime = System.currentTimeMillis();
		
		mergeSortTime = endTime - startTime;
		
		System.out.println("Merge sort time" + "(" + sortArrayGroupSize + "*" + sortArraySize + ")" + ":"  + (double)mergeSortTime / 1000 + "s");
	}
	
	public void quickSortTest() {
		SortAlgorithms [] sort = new SortAlgorithms [sortArrayGroupSize];
		
		long quickSortTime = 0;
		
		for(int i = 0; i < sortArrayGroupSize; i++){
			sort[i] = new SortAlgorithms();
		}
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < sortArrayGroupSize; i++) {
			sort[i].quickSort(nums, 0, nums.length);
			//sort[i].isSorted();
		}

		long endTime = System.currentTimeMillis();
		
		quickSortTime = endTime - startTime;
		
		System.out.println("Quick sort time" + "(" + sortArrayGroupSize + "*" + sortArraySize + ")" + ":"  + (double)quickSortTime / 1000 + "s");
	}
	
	/* Selection sort algorithm */
	public void selectionSort(int [] inputArray, int low, int high) {
		int tmpNum = 0;
		
		for(int i = 0; i < high; i++) {
			for(int j = i + 1; j < high; j++) {
				if(inputArray[j] < inputArray[i]) {
					tmpNum = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = tmpNum;
				}
			}
		}
	}
	
	/* Insertion sort algorithm */
	public void insertionSort(int [] inputArray, int low, int high) {
		int tmpNum = 0;
		
		for(int i = 1; i < high; i++) {
			for(int j = i; j > low; j--) {
				if(inputArray[j] < inputArray[j - 1]) {
					tmpNum = inputArray[j -1];
					inputArray[j - 1] = inputArray[j];
					inputArray[j] = tmpNum;
				}
			}
		}
	}
	
	/* Shell sort algorithm */
	public void shellSort(int [] inputArray, int low, int high) {
		int tmpNum = 0;
		int h = 1;
		
		if(h < (high - low) / 3) {
			h = 3 * h + 1;
		}
		
		while(h >= 1) {
			for(int i = h; i < high; i++) {
				for(int j = i; j >= h; j -= h) {
					if(inputArray[j] < inputArray[j - h]) {
						tmpNum = inputArray[j -h];
						inputArray[j - h] = inputArray[j];
						inputArray[j] = tmpNum;
					}
				}
			}
			h /= 3;
		}
	}
	
	/* Merge sort algorithm */
	public void mergeSort(int [] inputArray, int low, int high) {
		//System.out.println("Size: " + (sortArraySize - 1));
		doMergeSort(inputArray, low, high - 1);
	}
	
	private void doMergeSort(int [] inputArray, int low, int high) {
		if(low >= high) {
			return ;
		}
		
		int mid = low + (high -  low) / 2;
		
		doMergeSort(inputArray, low, mid);
		doMergeSort(inputArray, mid + 1, high);
		merge(inputArray, low, mid, high);
	}
	
	private void merge(int [] inputArray, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int [] tmpArray = new int [inputArray.length];
		
		for(int k = low; k <= high; k++) {
			tmpArray[k] = inputArray[k];
		}
		
		for(int k = low; k <= high; k++) {
			if(i > mid) {
				inputArray[k] = tmpArray[j++];
			}
			else if(j > high) {
				inputArray[k] = tmpArray[i++];
			}
			else if(tmpArray[i] > tmpArray[j]) {
				inputArray[k] = tmpArray[j++];
			}
			else {
				inputArray[k] = tmpArray[i++];
			}
		}
	}
	
	/* Quick sort algorithm */
	public void quickSort(int [] inputArray, int low, int high) {
		doQuickSort(inputArray, low, high - 1);
	}
	
	private void doQuickSort(int [] inputArray, int low, int high) {
		int mid = 0;
		
		if(low + 5 >= high) {
			
			return ;
		}
		
		mid = partition(inputArray, low, high);
		doQuickSort(inputArray, low, mid - 1);
		doQuickSort(inputArray, mid + 1, high);
	}
	
	private int partition(int [] inputArray, int low, int high) {
		int targetValue = inputArray[low];
		int i = 0, j = 0;
		int tmpNum = 0;
		
		while(true) {
			for(i = low + 1; i <= high; i++) {
				if(inputArray[i] > targetValue) {
					break;
				}
			}
			
			for(j = high; j >= low + 1; j--) {
				if(inputArray[j] < targetValue) {
					break;
				}
			}
			
			if(i < j) {
				tmpNum = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = tmpNum;
			}
			else {
				break;
			}
		}
		
		tmpNum = inputArray[j];
		inputArray[j] = targetValue;
		inputArray[low] = tmpNum;
		
		return j;
	}
	
	/* Print number list */
	public void show() {
		System.out.println("Numbers list:");
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
	}
	
	/* Check if number list is sorted */
	public boolean isSorted() {
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1]) {
				System.out.println("Unordered!");
				return false;
			}
		}
		
		return true;
	}
}


public class Heapsort {

	public void sort(int arr[]) 
	{ 
		int n = arr.length; 

		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 
		System.out.println("festlegen der Root: "+n);

		// One by one extract an element from heap 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Move current root to end 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			//System.out.println("Alle Zahlen kleiner als "+n+" werden in einem Array vermerkt");
			// call max heapify on the reduced heap 
			heapify(arr, i, 0); 
		} 
		System.out.println("Kontrolle welche Zahlen kleiner als die Root("+n+") ist");
	} 

	// To heapify a subtree rooted with node i which is 
	// an index in arr[]. n is size of heap 
	void heapify(int arr[], int n, int i) 
	{ 
		int largest = i; // Initialize largest as root 
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2 

		// If left child is larger than root 
		System.out.println("- in heapify(): Überprüfung ob linker Ast größer als Root("+n+") ist");
		if (l < n && arr[l] > arr[largest]) 
			largest = l; 

		// If right child is larger than largest so far 
		System.out.println("- in heapify(): Überprüfung ob rechter Ast größer als largest ("+l+") ist");
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 

		// If largest is not root 
		System.out.println("- in heapify(): wenn largest("+largest+") nicht root("+n+" ist wird largest mit root getauscht");
		if (largest != i) 
		{ 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 

			// Recursively heapify the affected sub-tree 
			heapify(arr, n, largest); 
		} 
	} 
	
	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		int n = arr.length; 

		Heapsort ob = new Heapsort(); 
		ob.sort(arr); 

		System.out.println("\n---------------\nSorted array is"); 
		printArray(arr); 
	} 

}

package names;
import io.IO;

public class Array{
	
	//the person array will be copied over to values
	Comparable values[];
	
	//length of the array
	int length;

	//keeps track of person comparisons made
	int comparisons;
	
	//keeps track of person swaps made
	int swaps;
	
	
	private static int left(int i){
		return 2*i + 1;
	}
	
	private static int right (int i){
		return 2*i + 2;
	}

	private static int lastInternal (int out){
		return (out/2) - 1;
	}
	
	private static boolean isLeaf (int i, int out){
		return i > lastInternal(out);
	}
	
	public int getSwaps(){
		return swaps;
	}
	
	public int getComps(){
		return comparisons;
	}
	
	//forms the sortable array,
	//takes a comparable (person) array as parameter
	public Array(Comparable[] people){
		values = new Comparable[people.length];
		for(int i = 0; i<people.length; i++){
			values[i] = people[i];
		}
		this.length = people.length;
		
		//initialize comparison and swap counters
		this.comparisons = 0;
		this.swaps = 0;
	} 
	
	public int length(){
		return this.length;
	}
	
	private void swap(int i, int j){
		//three swaps, because we are assigning a temp person
		Comparable temp = this.values[i];
		swaps++;
		this.values[i] = this.values[j];
		swaps++;
		this.values[j] = temp;
		swaps++;
	}
	
	
	
	/////////heapsort functions:
	
	private void makeHeap (int top, int out){
		makeHeap((Comparable) this.values[top], top, out);
	}
	
	private void makeHeap(Comparable v, int top, int out){
		if (Array.isLeaf(top, out)){
			//this counts as a swap because we're reassigning
			//an element of the array
			this.values[top] = v;
			swaps ++;
			return;
		}
		int larger;
		if (Array.right(top)<out){
			if (compare(this.values[Array.right(top)], this.values[Array.left(top)])>0){
				larger = Array.right(top);
				
			}
			else{
				larger = Array.left(top);
			}
		}
		else{
			larger = Array.left(top);
		}
		
		if (compare(v, this.values[larger])>0){
			//this counts as a swap because we're reassigning
			//an element of the array
			this.values[top] = v;
			swaps++;
			return;
		}
		this.values[top] = this.values[larger];
		
		//this counts as a swap because we're reassigning
		//an element of the array
		swaps++;
		makeHeap(v, larger, out);
	}
	
	public void heapsort(){
		int i;
		for (i = Array.lastInternal(this.length()); i>=0; i--){
			this.makeHeap(i, this.length());
		}
		
		for (i = this.length() - 1; i>0; i--){
			this.swap(0, i);
			this.makeHeap(0, i);
		}
	}
	
	
	
	/////////////quicksort functions:
	
	
	private int pivotIndex(int top, int out){
		
		//returns the median of the top, bottom and middle
		//members of the array
		//if array size is less than three, just return top
		if (out-top<3)
			{return top;}
		else{
			int mid = (int) ((top+out)/2);
			if (compare(top, mid)>0){
				if (compare(out-1, top)>0)
					{return top;}
				else if (compare(out-1, mid)>0)
					{return out-1;}
				else
				{return mid;}
			}
			else{
				if (compare(out-1, mid)>0)
					{return mid;}
				else if (compare(out-1, top)>0)
					{return out-1;}
				else 
					{return top;}
			}
		}
	}
	
	private int split(int top, int bot, int pivotIndex){
		swap(pivotIndex, bot);
		int i = top;
		for (int j = top; j < bot; j++){
			if (compare(this.values[j], this.values[bot])<0){
				swap(j, i++);
			}
		}
		swap(i, bot);
		return i;
	}
	
	public void quicksort(){
		quicksort(0, this.values.length);
	}
	
	private void quicksort(int top, int out){
		if (top < out-1){
			int mid = this.split(top, out-1, this.pivotIndex(top, out));
			this.quicksort(top, mid);
			this.quicksort(mid+1, out);
		}
	}
	
	private int compare(Comparable a, Comparable b){
		comparisons++;
		return a.compareTo(b);
	}
	
	
}

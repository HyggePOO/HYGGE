package dataStructures;
/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz & Kevin Rincón
 * 
 */
import data.NegocioBusqueda;
/*
public class PriorityQueue {
	private int maxSize;
	private int size;
	private NegocioBusqueda arr[];
	
	public PriorityQueue(int max){
		this.maxSize = max;
		size = 0;
		arr = new NegocioBusqueda[max+1];
	}
	
	private int parent(int i) {
		return (int)Math.floor(i/2);
	}
	
	private int leftChild(int i) {
		return 2*i;
	}
	
	private int rightChild(int i) {
		return 2*i +1;
	}
	
	public void insert(NegocioBusqueda p) {
		if (size==maxSize) {
			return;
		}
		arr[size] = p;
		size = size+1;
		siftUp(size);
		
	}
	
	private void siftUp(int i) {
		if (arr[i] ==null) {
			return;
		}
		while (i>1 && arr[parent(i)].getCalificacion()<arr[i].getCalificacion()) {
			swap(arr[parent(i)],arr[i]);
			i = parent(i);
		}
	}
	
	private void siftDown(int i) {
		int maxIndex = i;
		int l = leftChild(i);
		if (l<=size && arr[l].getCalificacion()>arr[maxIndex].getCalificacion()) {
			maxIndex = l;
		}
		int r = rightChild(i);
		if (r<=size && arr[r].getCalificacion()> arr[maxIndex].getCalificacion()) {
			maxIndex = r;
		}
		if (i!=maxIndex) {
			swap(arr[i],arr[maxIndex]);
			siftDown(maxIndex);
		}
	}
	
	private void swap(NegocioBusqueda a, NegocioBusqueda b) {
		int pa = getPos(a);
		int pb = getPos(b);
		arr[pa] = b;
		arr[pb] = a;
	}
	
	private int getPos(NegocioBusqueda a) {
		for (int i = 0; i<size;i++) {
			if(a.getNombre().equals(arr[i].getNombre())) {
				return i;
			}
		}
		return -1;
	}

	public NegocioBusqueda extractMax() {
		NegocioBusqueda result = arr[0];
		arr[0] = arr[size-1];
		size = size-1;
		siftDown(0);
		return result;
	}
	
	public NegocioBusqueda[] getQueue() {
		return arr;
	}
	
	public void print() {

		for(int i=0;i<size;i++) {
			System.out.print("");
		}
	}
}
*/
public class PriorityQueue {

	private int n;
	private NegocioBusqueda array[];
	private int size;
	
	public PriorityQueue(int n) {
		array=new NegocioBusqueda[n];
		size = 0;
	}
	

	public void insertItem(NegocioBusqueda x) {
//		if(size==n) {
//			return;
//		}
		array[size] = x;
		moveUp();
		size++;
	}

	private void moveUp() {
		int child = size;
		int parent = (child-1)/2;
		NegocioBusqueda temp = array[child];

	
		while(child > 0 && temp.getCalificacion() > array[parent].getCalificacion()) {
			array[child] = array[parent];
			child = parent;
			parent = (child-1)/2;
		}
		array[child]=temp;
	}


	public NegocioBusqueda removeMax() {

		NegocioBusqueda max=array[0];
		array[0]=array[--size];
		moveDown();
		return max;

	}


	private void moveDown() {

	boolean flag = false;
	NegocioBusqueda biggest = null;
	int parent = 0;
	int child = 2*parent+1;
	NegocioBusqueda temp = array[parent];
	while(child < size && !flag) {
		biggest = array[child];
		if(child+1 < size && array[child+1].getCalificacion() > array[child].getCalificacion())
			biggest = array[++child];
		if(biggest.getCalificacion() > temp.getCalificacion()) {
			array[parent] = biggest;
			parent = child;
			}else
				flag = true;
		child = 2*parent+1;
		}
	array[parent] = temp;

	}
}